
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

//Fixes so test go alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
/*
 * @author oliversimpson
 */

public class DatabaseHandlingTest {
    
    public DatabaseHandlingTest() {
    }
 
    //rule allows us to check for thrown exceptions
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    
    //Must Run off clean database, do to name collsion as StaffName is unqiue, if unique collison is found no update is made
    
    @Test //Tests that inserting into the database works, throws exception is two same are found
    public void B_testAddStaff() throws Exception {
        System.out.println("Add staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname1","Owen Kelbie", "Admin", "Testpswd");
    }
    
    @Test //Tests remove staff does not throw exception when done correctly, throws exception if doesnt exist
    public void C_testRemoveStaff() throws Exception {
        System.out.println("Remove Staff");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname2", "remove me", "Testrole", "Testpswd");
        instance.removeStaff("Testname2");
    }

    @Test 
    public void D_testEditStaffUserName() throws Exception {
        System.out.println("Edit staff UserName");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname4","edit my username", "EC", "Testpswd");
        instance.editStaffUserName("Testname3","Sausage");
    }

      @Test 
    public void Da_testEditStaffName() throws Exception {
        System.out.println("Edit staff Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname3","Campell Krud", "IM", "Testpswd");
        instance.editStaffName("Testname3","Sausage");
    }
    
    @Test 
    public void E_testEditStaffRole() throws Exception {
        System.out.println("Edit staff Role");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Lenard", "Lenard", "IM", "Testpswd");
        instance.editStaffRole("Lenard","ES");
    }

    @Test
    public void F_testEditStaffPassword() throws Exception {
        System.out.println("Edit staff Password");
        DatabaseHandling instance = new DatabaseHandling();
        instance.addStaff("Testname5", "Worng password fool", "EX", "Testpswd");
        instance.editStaffPassword("Testname5","Fish");
    }

    

    @Test
    public void G_testCreateExam() throws Exception {
        System.out.println("Create Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC131","Dundee","Science & Engineering","2019", "Lenard");
    }

    @Test
    public void H_testDeleteExam() throws Exception {
        System.out.println("Delete Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC132","Dundee","Science & Engineering","2019", "Testname1");
        instance.deleteExam(2);
    }

    @Test
    public void I_testEditExamStatus() throws Exception {
        System.out.println("Edit Exam Status");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC133","Dundee","Science & Engineering","2019", "Testname3");
        instance.editExamStatus(3,"Complete");
    }


    @Test
    public void J_testEditExamModuleName() throws Exception {
        System.out.println("Edit Exam Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC134","Dundee","Science & Engineering","2019", "Testname4");
        instance.editExamModuleName(4,"Biznes");
    }

    @Test
    public void K_testEditExamModuleCode() throws Exception {
        System.out.println("Edit Exam Code");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC135","Dundee","Science & Engineering","2019", "Testname5");
        instance.editExamModuleCode(5,"AC12");
    }

    @Test
    public void L_testEditExamInstitution() throws Exception {
        System.out.println("Edit Exam Institution");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC136","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamInstitution(6,"Abertay");
    }

    @Test
    public void M_testEditExamSchool() throws Exception {
        System.out.println("Edit Exam School");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC137","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamSchool(7,"Law");
    }
    
    @Test
    public void N_testEditExamAcedmeicYear() throws Exception {
        System.out.println("Edit Exam Year");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC138","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamAcademicYear(8,"2019");
    }
    
    @Test
     public void O_testInternalAssignExam() throws Exception {
         System.out.println("Internal Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC139","Dundee","Science & Engineering","2019", "Lenard");
         instance.internalAssignExam(9,"Lenard");
     }
    
    @Test
    public void Oa_testInternalSignExam() throws Exception {
        System.out.println("Internal Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalSignExam(9);
    }
    
    @Test
    public void Ob_testInternalSignExamDeadline() throws Exception {
        System.out.println("Internal Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalAssignExamDeadline(9, "2019-01-29");
    }
    
     @Test
     public void P_testCommiteeAssignExam() throws Exception {
         System.out.println("Commitee Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC140","Dundee","Science & Engineering","2019", "Lenard");
         instance.examCommiteeAssignExam(10,"Testname4");
     }
    
    @Test
    public void Pa_testExamCommiteeSignExam() throws Exception {
        System.out.println("Commitee Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeSignExam(10);
    }
    
     @Test
    public void Pb_testCommiteeSignExamDeadline() throws Exception {
        System.out.println("Commitee Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeAssignExamDeadline(10, "2019-01-29");
    }

     @Test
     public void Q_testExternalAssignExam() throws Exception {
         System.out.println("External Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC141","Dundee","Science & Engineering","2019", "Lenard");
         instance.externalAssignExam(11,"Testname5");
     }
    
    @Test
    public void Qa_testExternalSignExam() throws Exception {
        System.out.println("External Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalSignExam(11);
    }
    
     @Test
    public void Qb_testExternalSignExamDeadline() throws Exception {
        System.out.println("External Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalAssignExamDeadline(11, "2019-01-29");
    }
    
    @Test
    public void R_testKillCon() throws Exception {
        System.out.println("killCon");
        DatabaseHandling instance = new DatabaseHandling();
        instance.killCon();
    }
    
    @Test 
    public void S_createAdditionalStaffForFurther() throws Exception {
       System.out.println("killCon");
       DatabaseHandling instance = new DatabaseHandling();
       instance.addStaff("Testname6", "Same exam as last year", "ES", "Testpswd");
       instance.addStaff("Testname7", "Office bois", "SO", "Testpswd");
    }
}
  

