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
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
    

    @Test //Tests that inserting into the database works
    public void B_testAddStaff() throws Exception {
        System.out.println("Add staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname", "Testrole", "Testpswd");
    }
    
    @Test
    public void C_testRemoveStaff() throws Exception {
        System.out.println("Remove Staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname", "Testrole", "Testpswd");
        instance.removeStaff(2);
    }

    @Test
    public void D_testEditStaffName() throws Exception {
        System.out.println("Edit staff Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname", "Testrole", "Testpswd");
        instance.editStaffName(3,"Sausage");
    }

    @Test
    public void E_testEditStaffRole() throws Exception {
        System.out.println("Edit staff Role");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname", "Testrole", "Testpswd");
        instance.editStaffRole(4,"Pie");
    }

    @Test
    public void F_testEditStaffPassword() throws Exception {
        System.out.println("Edit staff Password");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname", "Testrole", "Testpswd");
        instance.editStaffPassword(5,"Fish");
    }

    @Test
    public void G_testCreateExam() throws Exception {
        System.out.println("Create Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
    }

    @Test
    public void H_testDeleteExam() throws Exception {
        System.out.println("Delete Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.deleteExam(2);
    }

    @Test
    public void I_testEditExamStatus() throws Exception {
        System.out.println("Edit Exam Status");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamStatus(3,"in progress");
    }


    @Test
    public void J_testEditExamModuleName() throws Exception {
        System.out.println("Edit Exam Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamModuleName(4,"Biznes");
    }

    @Test
    public void K_testEditExamModuleCode() throws Exception {
        System.out.println("Edit Exam Code");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamModuleCode(5,"AC12");
    }

    @Test
    public void L_testEditExamInstitution() throws Exception {
        System.out.println("Edit Exam Institution");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamInstitution(6,"Dundee High");
    }

    @Test
    public void M_testEditExamSchool() throws Exception {
        System.out.println("Edit Exam School");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamSchool(7,"Arts and crafts");
    }
    
    @Test
    public void N_testEditExamAcedmeicYear() throws Exception {
        System.out.println("Edit Exam Year");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC130","Scumdee","Biz","1984");
        instance.editExamAcademicYear(8,"2019");
    }
    
    @Test
     public void O_testInternalAssignExam() throws Exception {
         System.out.println("Internal Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC130","Scumdee","Biz","1984");
         instance.internalAssignExam(9,1);
     }
    
    @Test
    public void Oa_testInternalSignExam() throws Exception {
        System.out.println("Internal Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalSignExam(9);
    }
    
     @Test
     public void P_testInternalAssignExam() throws Exception {
         System.out.println("Commitee Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC130","Scumdee","Biz","1984");
         instance.examCommiteeAssignExam(10,1);
     }
    
    @Test
    public void Pa_testExamCommiteeSignExam() throws Exception {
        System.out.println("Commitee Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeSignExam(10);
    }

     @Test
     public void Q_testExternalAssignExam() throws Exception {
         System.out.println("External Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC130","Scumdee","Biz","1984");
         instance.externalAssignExam(11,1);
     }
    
    @Test
    public void Qa_testExternalSignExam() throws Exception {
        System.out.println("External Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalSignExam(11);
    }

    @Test
    public void R_testKillCon() throws Exception {
        System.out.println("killCon");
        DatabaseHandling instance = new DatabaseHandling();
        instance.killCon();
    }
}
  

