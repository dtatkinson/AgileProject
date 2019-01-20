/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 *
 * @author oliversimpson
 */

public class DatabaseHandlingTest {
    
    public DatabaseHandlingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
    }
    
    @After
    public void tearDown() {
    }

    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    
    
    @Test(expected = Test.None.class) //Test that a connection has been established i.e no exception thrown
    public void testMain() throws Exception {
        String[] args = null;
        DatabaseHandling.main(args);    
    }
    
    @Test //Tests that inserting into the database works
    public void testAddStaff() throws Exception {
        System.out.println("Add staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff(1,"Testname", "Testrole", "Testpswd");
    }
    
    @Test
    public void testRemoveStaff() throws Exception {
        System.out.println("Remove Staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff(2,"Testname", "Testrole", "Testpswd");
        instance.removeStaff(1);
    }

    @Test
    public void testEditStaffName() throws Exception {
        System.out.println("Edit staff Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff(3,"Testname", "Testrole", "Testpswd");
        instance.editStaffName(3,"Sausage");
    }

    @Test
    public void testEditStaffRole() throws Exception {
        System.out.println("Edit staff Role");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff(4,"Testname", "Testrole", "Testpswd");
        instance.editStaffRole(4,"Pie");
    }

    @Test
    public void testEditStaffPassword() throws Exception {
        System.out.println("Edit staff Password");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff(4,"Testname", "Testrole", "Testpswd");
        instance.editStaffPassword(5,"Fish");
    }

    @Test
    public void testCreateExam() throws Exception {
        System.out.println("Create Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(1,"Comp","AC130","Scumdee","Biz","1984");
    }

    @Test
    public void testDeleteExam() throws Exception {
        System.out.println("Delete Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(2,"Comp","AC130","Scumdee","Biz","1984");
        instance.deleteExam(2);
    }

    @Test
    public void testEditExamStatus() throws Exception {
        System.out.println("Edit Exam Status");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(3,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamStatus(3,"in progress");
    }


    @Test
    public void testEditExamModuleName() throws Exception {
        System.out.println("Edit Exam Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(4,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamModuleName(4,"Biznes");
    }

    @Test
    public void testEditExamModuleCode() throws Exception {
        System.out.println("Edit Exam Code");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(5,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamModuleCode(5,"AC12");
    }

    @Test
    public void testEditExamInstitution() throws Exception {
        System.out.println("Edit Exam Institution");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(6,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamInstitution(6,"Dundee High");
    }

    @Test
    public void testEditExamSchool() throws Exception {
        System.out.println("Edit Exam School");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(7,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamSchool(7,"Arts and crafts");
    }
    
    @Test
    public void testEditExamAcedmeicYear() throws Exception {
        System.out.println("Edit Exam Year");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(8,"Comp","AC130","Scumdee","Biz","1984");
        instance.editExamAcademicYear(8,"2019");
    }

    @Test
    public void testInternalSignExam() throws Exception {
        System.out.println("Internal Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(9,"Comp","AC130","Scumdee","Biz","1984");
        instance.internalSignExam(9,2);
    }

    @Test
    public void testInternalDateEdit() throws Exception {
  
    }

    @Test
    public void testExamCommiteeSignExam() throws Exception {
        System.out.println("Commitee Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(10,"Comp","AC130","Scumdee","Biz","1984");
        instance.examCommiteeSignExam(10,2);
    }

    @Test
    public void testExamCommiteeDateEdit() throws Exception {
        
    }

    @Test
    public void testExternalSignExam() throws Exception {
        System.out.println("External Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam(11,"Comp","AC130","Scumdee","Biz","1984");
        instance.examCommiteeSignExam(11,2);
    }

    @Test
    public void testExternalDateEdit() throws Exception {
       
    }
    /*
    @Test
    public void testKillCon() throws Exception {
        System.out.println("killCon");
        DatabaseHandling instance = new DatabaseHandling();
        instance.killCon();
    }
**/
}
  

