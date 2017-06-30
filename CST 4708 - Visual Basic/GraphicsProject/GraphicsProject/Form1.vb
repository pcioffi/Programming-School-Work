Public Class Form1

    Private Sub Form1_Paint(sender As Object, e As PaintEventArgs) Handles Me.Paint
        Dim ourgraphics As Graphics = e.Graphics
        Dim ourPen As New Pen(Color.Gray, 10)
        Dim red As New SolidBrush(Color.Red)
        Dim b As New SolidBrush(Color.Black)
        Dim width As Integer = 40
        Dim height As Integer = 40
        For i As Integer = 1 To 8
            For j As Integer = 0 To 7
                If b.Color = Color.Black Then
                    b.Color = Color.Red
                Else
                    b.Color = Color.Black
                End If
                ourgraphics.FillRectangle(b, (j) * width, height * i, width, height)
                ourgraphics.DrawRectangle(ourPen, j * width, height * i, width, height)

            Next j
            If b.Color = Color.Black Then
                b.Color = Color.Red
            Else
                b.Color = Color.Black
            End If
        Next i
        ourgraphics.DrawArc(ourPen, 50, 500, 50, 70, 0, 360)
        Dim myfont As New Font(FontFamily.GenericSansSerif, 48)
        b.Color = Color.Red
        ourgraphics.DrawString("HELLO", myfont, b, 100, 500)
       




    End Sub
End Class
