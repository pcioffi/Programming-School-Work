Imports Microsoft.VisualBasic
Imports System.Data.SqlClient
Imports System.Data
Public Class DB
    Public Function getStudents() As Datatable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select * from Students "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
    Public Function getMajors() As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select SMajor from Students group by SMajor "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function

    ' Professors Table
    Public Function getProfessors() As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select * from Professors "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function

    ' Courses Table
    Public Function getCourses() As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select * from Courses "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
    Public Function getProfList() As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select PName from Professors group by PName "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
    Public Function getStudentList() As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = "Select SName from Students group by SName "
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
    Public Function getProfCourse(pname As String) As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = String.Format("Select PCourse from Professors Where PName = '{0}' ", pname)
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
    Public Function getValuesList(searchBy As String) As DataTable
        Dim myconn As New SqlConnection
        Dim myadapter As New SqlDataAdapter
        Dim mycommand As New SqlCommand
        Dim mytable As New DataTable
        myconn.ConnectionString = "Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=C:\Users\Zero\Desktop\Assignment2(1)\App_Data\Assign2.mdf;Integrated Security=True;Connect Timeout=30"
        myadapter.SelectCommand = mycommand
        mycommand.Connection = myconn
        mycommand.CommandType = CommandType.Text
        mycommand.CommandText = String.Format("Select {0} from Courses group by {0} ", searchBy)
        mytable.Clear()
        myadapter.Fill(mytable)
        myconn.Close()
        Return mytable
    End Function
End Class
