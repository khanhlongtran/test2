
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Main {

    public static void main(String[] args) {

        // Bởi vì thằng Date này nó hiện thị ra rất nhiều thông tin như 
        // Wed Dec 21 20:50:49 ICT 2022 từ lệnh bên dưới. Do đó để đơn giản vấn dề
        // thì ta thường sử dụng mẫu tức là pattern giống với regex như dd MMM YYYY gì đó 
        // => Kinh nghiệm: Sử dụng SimpleDateFormat và truyền patern vào đấy cho nó là được
        // Hơn nữa: format = date -> string
        //          parse  = string -> date
        // System.out.println(currentDate.toString());      
        /*
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String current = dateFormat.format(currentDate);
        System.out.println(current);
         */
        //======================================================================
        //convert Date -> String thì sử dụng biến SimpleDateFormat hiện tại ở đây 
        // là dateFormat và phương phức format để chuyển sang String 
        // Và tương tự: Ngược lại nếu muốn chuyển từ String sang Date
        // thì ta lại sử dụng biến SimpleDateFormat và phương thức parse 
        // nếu có parse thì phải thêm surrounding try-catch
        /*
        String date = "21/12/1999";       
        try {
            Date beConvertToDate = dateFormat.parse(date);
            System.out.println(beConvertToDate.toString());
            // answer is: Tue Dec 21 00:00:00 ICT 1999
           
        } catch (ParseException ex) {
            System.out.println("Cannot parse!");
        }
         */
        //======================================================================
        // Trong phần ngày tháng thì có vài bug ẩn như sau: đó là nếu như
        // ta nhập vào ngày 31/2 thì máy sẽ tự động chuyển sang  3/3 thì
        // có hàm setLenient với tham số mặc định là true
        // nên nếu muốn checkDate đúng hay sai thì ta phải đưa tham số về false
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        dateFormat.setLenient(false);
        System.out.println("Input day/month/year: ");
        String inputDate = sc.nextLine();

        try {
            Date dateInput = dateFormat.parse(inputDate);
            inputDate = dateFormat.format(dateInput);
            System.out.println("New: " + inputDate);
            /*
            Input day/month/year: 
            31/2/2022
            New: 03/03/2022
             */ 
            // với TH: dateFormat.setLenient(true);
        } catch (ParseException ex) {
            System.out.println("Cannot parse");
            // dateFormat.setLenient(false); 
            // => output sẽ là cannot parse
        }

    }
}
