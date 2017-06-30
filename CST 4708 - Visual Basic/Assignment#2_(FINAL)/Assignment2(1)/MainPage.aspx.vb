Imports System.Data
Partial Class MainPage
    Inherits System.Web.UI.Page
    Dim mytable As New DataTable
    Dim majortable As DataTable
    Dim proftable As DataTable
    Dim coursetable As DataTable
    Dim cproftable As DataTable
    Dim cstudenttable As DataTable
    Dim valuestable As DataTable
    Protected Sub Page_Load(sender As Object, e As EventArgs) Handles Me.Load
        If IsPostBack Then
            mytable = Session("StudentTable")
            majortable = Application("Majorstable")
            proftable = Session("ProfessorTable")
            coursetable = Session("CourseTable")
            cproftable = Application("ProfListtable")
            cstudenttable = Application("StudentListtable")
            valuestable = Application("SearchByValuestable")
        Else
            Dim mydb As New DB
            majortable = Application("Majorstable")
            cproftable = Application("ProfListtable")
            cstudenttable = Application("StudentListtable")
            valuestable = Application("SearchByValuestable")
            If majortable Is Nothing Then
                majortable = mydb.getMajors
                Application("Majorstable") = majortable
            End If
            If cproftable Is Nothing Then
                cproftable = mydb.getProfList
                Application("ProfListtable") = cproftable
            End If
            If cstudenttable Is Nothing Then
                cstudenttable = mydb.getStudentList
                Application("StudentListtable") = cstudenttable
            End If

            Dim searchBy As String
            If lstSrchby.SelectedItem.Value.Equals("Students") Then
                searchBy = "Students"
            End If
            If lstSrchby.SelectedItem.Value.Equals("Professors") Then
                searchBy = "Professors"
            End If
            If lstSrchby.SelectedItem.Value.Equals("Courses") Then
                searchBy = "Courses"
            End If
            If valuestable Is Nothing Then
                valuestable = mydb.getValuesList(lstSrchby.SelectedValue)
                Application("SearchByValuestable") = valuestable
            End If

            mytable = mydb.getStudents
            proftable = mydb.getProfessors
            coursetable = mydb.getCourses

            lstProfSel.DataSource = cproftable
            lstProfSel.DataTextField = "PName"
            lstProfSel.DataBind()

            lstStudentSel.DataSource = cstudenttable
            lstStudentSel.DataTextField = "SName"
            lstStudentSel.DataBind()

            lstSrchValues.DataSource = valuestable
            lstSrchValues.DataTextField = lstSrchby.SelectedValue
            lstSrchValues.DataBind()
        End If
    End Sub

    Protected Sub Page_PreRender(sender As Object, e As EventArgs) Handles Me.PreRender
        Session("StudentTable") = mytable
        Session("Majorstable") = majortable
        Session("ProfessorTable") = proftable
        Session("CourseTable") = coursetable
        Session("ProfListtable") = cproftable
        Session("StudentListtable") = cstudenttable

        gvStudent.DataSource = mytable
        gvProf.DataSource = proftable
        gvCourse.DataSource = coursetable

        gvStudent.DataBind()
        gvProf.DataBind()
        gvCourse.DataBind()
    End Sub

    ' Students START
    Protected Sub btnADDStudent_Click(sender As Object, e As EventArgs) Handles btnADDStudent.Click
        Dim newrow As DataRow
        newrow = mytable.NewRow
        newrow.Item("SID") = txtStudentID.Text
        newrow.Item("Sname") = txtStudentName.Text
        newrow.Item("SMajor") = lstMajor.SelectedItem.Value
        mytable.Rows.Add(newrow)
    End Sub

    Protected Sub gvStudent_RowCancelingEdit(sender As Object, e As GridViewCancelEditEventArgs) Handles gvStudent.RowCancelingEdit
        gvStudent.EditIndex = -1
    End Sub

    Protected Sub gvStudent_RowDataBound(sender As Object, e As GridViewRowEventArgs) Handles gvStudent.RowDataBound
        If (e.Row.RowType = DataControlRowType.DataRow) Then
            Dim myddl As DropDownList
            myddl = CType(e.Row.FindControl("ddlmajors"), DropDownList)
            If myddl Is Nothing Then Return
            myddl.DataSource = majortable
            myddl.DataTextField = "SMajor"
            myddl.DataBind()
            myddl.SelectedIndex = myddl.Items.IndexOf(myddl.Items.FindByText(mytable.Rows(e.Row.DataItemIndex).Item("SMajor")))
        End If
    End Sub

    Protected Sub gvStudent_RowDeleting(sender As Object, e As GridViewDeleteEventArgs) Handles gvStudent.RowDeleting
        mytable.Rows(gvStudent.Rows(e.RowIndex).DataItemIndex).Delete()
    End Sub

    
    Protected Sub gvStudent_RowEditing(sender As Object, e As GridViewEditEventArgs) Handles gvStudent.RowEditing
        gvStudent.EditIndex = e.NewEditIndex
    End Sub


    Protected Sub gvStudent_RowUpdating(sender As Object, e As GridViewUpdateEventArgs) Handles gvStudent.RowUpdating
        Dim sid, sname, smajor As String
        Dim id As Integer
        sid = e.NewValues("SID")
        sname = e.NewValues("Sname")
        id = e.NewValues("ID")

        Dim myddl As DropDownList
        myddl = CType(gvStudent.Rows(e.RowIndex).FindControl("ddlmajors"), DropDownList)
        smajor = myddl.SelectedItem.Text

        mytable.Rows(gvStudent.Rows(e.RowIndex).DataItemIndex).Item("SName") = sname
        mytable.Rows(gvStudent.Rows(e.RowIndex).DataItemIndex).Item("SID") = sid
        mytable.Rows(gvStudent.Rows(e.RowIndex).DataItemIndex).Item("SMajor") = smajor

        gvStudent.EditIndex = -1
    End Sub
    ' Students END

    ' Professor START
    Private Sub btnAddProf_Click(sender As Object, e As EventArgs) Handles btnAddProf.Click
        Dim newrow As DataRow
        newrow = proftable.NewRow
        newrow.Item("PName") = txtProfName.Text
        newrow.Item("POffice") = txtLocation.Text
        newrow.Item("PPhone") = txtPhone.Text
        newrow.Item("PCourse") = txtCourse.Text
        proftable.Rows.Add(newrow)
    End Sub

    Private Sub gvProf_RowEditing(sender As Object, e As GridViewEditEventArgs) Handles gvProf.RowEditing
        gvProf.EditIndex = e.NewEditIndex
    End Sub

    Private Sub gvProf_RowUpdating(sender As Object, e As GridViewUpdateEventArgs) Handles gvProf.RowUpdating
        Dim pname, plocation, pnumber, pcourse As String
        Dim id As Integer
        pname = e.NewValues("PName")
        plocation = e.NewValues("POffice")
        pnumber = e.NewValues("PPhone")
        pcourse = e.NewValues("PCourse")
        id = e.NewValues("ID")

        proftable.Rows(gvProf.Rows(e.RowIndex).DataItemIndex).Item("PName") = pname
        proftable.Rows(gvProf.Rows(e.RowIndex).DataItemIndex).Item("POffice") = plocation
        proftable.Rows(gvProf.Rows(e.RowIndex).DataItemIndex).Item("PPhone") = pnumber
        proftable.Rows(gvProf.Rows(e.RowIndex).DataItemIndex).Item("PCourse") = pcourse

        gvProf.EditIndex = -1
    End Sub

    Private Sub gvProf_RowCancelingEdit(sender As Object, e As GridViewCancelEditEventArgs) Handles gvProf.RowCancelingEdit
        gvProf.EditIndex = -1
    End Sub

    Private Sub gvProf_RowDeleting(sender As Object, e As GridViewDeleteEventArgs) Handles gvProf.RowDeleting
        proftable.Rows(gvProf.Rows(e.RowIndex).DataItemIndex).Delete()
    End Sub
    ' Professor END

    ' Course START
    Private Sub btnAddCourse_Click(sender As Object, e As EventArgs) Handles btnAddCourse.Click
        Dim newrow As DataRow
        newrow = coursetable.NewRow

        Dim mydb As New DB
        Dim data As New DataTable
        Dim pname As String
        pname = lstProfSel.SelectedItem.Value
        data = mydb.getProfCourse(pname)

        newrow.Item("CNumber") = data.Rows(0).Item("PCourse")
        newrow.Item("CStudent") = lstStudentSel.SelectedItem.Value
        newrow.Item("CProfessor") = lstProfSel.SelectedItem.Value
        newrow.Item("CGrade") = txtGrade.Text
        coursetable.Rows.Add(newrow)
    End Sub

    Private Sub gvCourse_RowEditing(sender As Object, e As GridViewEditEventArgs) Handles gvCourse.RowEditing
        gvCourse.EditIndex = e.NewEditIndex
    End Sub

    Private Sub gvCourse_RowUpdating(sender As Object, e As GridViewUpdateEventArgs) Handles gvCourse.RowUpdating
        Dim cnumber, cstudent, cprofessor, cgrade As String
        Dim id As Integer
        cnumber = e.NewValues("CNumber")
        cstudent = e.NewValues("CStudent")
        cprofessor = e.NewValues("CProfessor")
        cgrade = e.NewValues("CGrade")
        id = e.NewValues("ID")

        coursetable.Rows(gvCourse.Rows(e.RowIndex).DataItemIndex).Item("CNumber") = cnumber
        coursetable.Rows(gvCourse.Rows(e.RowIndex).DataItemIndex).Item("CStudent") = cstudent
        coursetable.Rows(gvCourse.Rows(e.RowIndex).DataItemIndex).Item("CProfessor") = cprofessor
        coursetable.Rows(gvCourse.Rows(e.RowIndex).DataItemIndex).Item("CGrade") = cgrade

        gvCourse.EditIndex = -1
    End Sub

    Private Sub gvCourse_RowCancelingEdit(sender As Object, e As GridViewCancelEditEventArgs) Handles gvCourse.RowCancelingEdit
        gvCourse.EditIndex = -1
    End Sub

    Private Sub gvCourse_RowDeleting(sender As Object, e As GridViewDeleteEventArgs) Handles gvCourse.RowDeleting
        coursetable.Rows(gvCourse.Rows(e.RowIndex).DataItemIndex).Delete()
    End Sub
    ' Course END

    ' GPACalculation START
    Private Sub lstSrchby_SelectedIndexChanged(sender As Object, e As EventArgs) Handles lstSrchby.SelectedIndexChanged
        Dim ddlSB As New DropDownList
        ddlSB.FindControl("lstSrchBy")

        Dim mydb As New DB
        If ddlSB.SelectedIndex.Equals(e) Then
            valuestable = mydb.getValuesList(ddlSB.SelectedItem.Value)
        End If

        lstSrchValues.DataSource = valuestable
        lstSrchValues.DataTextField = ddlSB.SelectedValue
        lstSrchValues.DataBind()
    End Sub

    Private Sub gpaButton_Click(sender As Object, e As EventArgs) Handles gpaButton.Click

    End Sub
End Class
