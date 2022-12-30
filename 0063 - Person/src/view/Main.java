
package view;

/**
 *
 * @author Administrator
 */
public class Main {
    public static void main(String[] args) {
        View_Person view = new View_Person();
        
        // input data
        view.inputData();
        // sort list person by salary ascending
        view.sortPerson();
        // display all information that user entered
        view.displayInformation();
    }
}
