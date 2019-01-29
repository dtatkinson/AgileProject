
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
    public void GR_testCreateResitExam() throws Exception {
        System.out.println("Create Resit Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC131","Dundee","Science & Engineering","2019", "Lenard");
    }

    @Test
    public void H_testDeleteExam() throws Exception {
        System.out.println("Delete Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC132","Dundee","Science & Engineering","2019", "Testname1");
        instance.deleteExam(2);
    }
     @Test
    public void HR_testDeleteExam() throws Exception {
        System.out.println("Delete Resit Exam");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC132","Dundee","Science & Engineering","2019", "Testname1");
        instance.deleteResitExam(2);
    }
    

    @Test
    public void I_testEditExamStatus() throws Exception {
        System.out.println("Edit Exam Status");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC133","Dundee","Science & Engineering","2019", "Testname3");
        instance.editExamStatus(3,"Complete");
    }
    
     @Test
    public void IR_testEditResitExamStatus() throws Exception {
        System.out.println("Edit Resit Exam Status");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC133","Dundee","Science & Engineering","2019", "Testname3");
        instance.editResitExamStatus(3,"Complete");
    }


    @Test
    public void J_testEditExamModuleName() throws Exception {
        System.out.println("Edit Exam Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC134","Dundee","Science & Engineering","2019", "Testname4");
        instance.editExamModuleName(4,"Biznes");
    }
    
    @Test
    public void JR_testEditResitExamModuleName() throws Exception {
        System.out.println("Edit Resit Exam Name");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC134","Dundee","Science & Engineering","2019", "Testname4");
        instance.editResitExamModuleName(4,"Biznes");
    }

    @Test
    public void K_testEditExamModuleCode() throws Exception {
        System.out.println("Edit Exam Code");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC135","Dundee","Science & Engineering","2019", "Testname5");
        instance.editExamModuleCode(5,"AC12");
    }
    
     @Test
    public void KR_testEditResitExamModuleCode() throws Exception {
        System.out.println("Edit Resit Exam Code");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC135","Dundee","Science & Engineering","2019", "Testname5");
        instance.editResitExamModuleCode(5,"AC12");
    }

    @Test
    public void L_testEditExamInstitution() throws Exception {
        System.out.println("Edit Exam Institution");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC136","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamInstitution(6,"Abertay");
    }
    
   @Test
    public void LR_testEditResitExamInstitution() throws Exception {
        System.out.println("Edit Resit Exam Institution");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC136","Dundee","Science & Engineering","2019", "Lenard");
        instance.editResitExamInstitution(6,"Abertay");
    }

    @Test
    public void M_testEditExamSchool() throws Exception {
        System.out.println("Edit Exam School");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC137","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamSchool(7,"Law");
    }
    
    @Test
    public void MR_testResitEditExamSchool() throws Exception {
        System.out.println("Edit Resit Exam School");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC137","Dundee","Science & Engineering","2019", "Lenard");
        instance.editResitExamSchool(7,"Law");
    }
    
    @Test
    public void N_testEditExamAcedmeicYear() throws Exception {
        System.out.println("Edit Exam Year");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createExam("Comp","AC138","Dundee","Science & Engineering","2019", "Lenard");
        instance.editExamAcademicYear(8,"2019");
    }
    
    @Test
    public void NR_testEditResitExamAcedmeicYear() throws Exception {
        System.out.println("Edit Resit Exam Year");
        DatabaseHandling instance = new DatabaseHandling();
        instance.createResitExam("Comp","AC138","Dundee","Science & Engineering","2019", "Lenard");
        instance.editResitExamAcademicYear(8,"2019");
    }
    
    @Test
     public void O_testInternalAssignExam() throws Exception {
         System.out.println("Internal Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC139","Dundee","Science & Engineering","2019", "Lenard");
         instance.internalAssignExam(9,"Lenard");
     }
     
     @Test
     public void OR_testInternalAssignResitExam() throws Exception {
         System.out.println("Internal Resit Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createResitExam("Comp","AC139","Dundee","Science & Engineering","2019", "Lenard");
         instance.internalAssignResitExam(9,"Lenard");
     }
    
    @Test
    public void Oa_testInternalSignExam() throws Exception {
        System.out.println("Internal Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalSignExam(9);
    }
    
    @Test
    public void OaR_testInternalSignResitExam() throws Exception {
        System.out.println("Internal Resit Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalSignResitExam(9);
    }
    
    @Test
    public void Ob_testInternalSignExamDeadline() throws Exception {
        System.out.println("Internal Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalAssignExamDeadline(9, "2019-01-29");
    }
    
    @Test
    public void ObR_testInternalSignResitExamDeadline() throws Exception {
        System.out.println("Internal Resit Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.internalAssignResitExamDeadline(9, "2019-01-29");
    }
    
     @Test
     public void P_testCommiteeAssignExam() throws Exception {
         System.out.println("Commitee Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC140","Dundee","Science & Engineering","2019", "Lenard");
         instance.examCommiteeAssignExam(10,"Testname4");
     }
     
     @Test
     public void PR_testCommiteeAssignResitExam() throws Exception {
         System.out.println("Commitee Resit Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createResitExam("Comp","AC140","Dundee","Science & Engineering","2019", "Lenard");
         instance.examCommiteeAssignResitExam(10,"Testname4");
     }
    
    @Test
    public void Pa_testExamCommiteeSignExam() throws Exception {
        System.out.println("Commitee Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeSignExam(10);
    }
      
    @Test
    public void PaR_testExamCommiteeSignResitExam() throws Exception {
        System.out.println("Commitee Resit Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeSignResitExam(10);
    }
    
    
     @Test
    public void Pb_testCommiteeSignExamDeadline() throws Exception {
        System.out.println("Commitee Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeAssignExamDeadline(10, "2019-01-29");
    }
    
     @Test
    public void PbR_testCommiteeSignResitExamDeadline() throws Exception {
        System.out.println("Commitee Resit Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.examCommiteeAssignResitExamDeadline(10, "2019-01-29");
    }

     @Test
     public void Q_testExternalAssignExam() throws Exception {
         System.out.println("External Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createExam("Comp","AC141","Dundee","Science & Engineering","2019", "Lenard");
         instance.externalAssignExam(11,"Testname5");
     }
     
       @Test
     public void QR_testExternalAssignResitExam() throws Exception {
         System.out.println("External Resit Exam Assigned");
         DatabaseHandling instance = new DatabaseHandling();
         instance.createResitExam("Comp","AC141","Dundee","Science & Engineering","2019", "Lenard");
         instance.externalAssignResitExam(11,"Testname5");
     }
    
    @Test
    public void Qa_testExternalSignExam() throws Exception {
        System.out.println("External Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalSignExam(11);
    }
    
      @Test
    public void QaR_testExternalSignResitExam() throws Exception {
        System.out.println("External Resit Exam signed");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalSignResitExam(11);
    }
    
     @Test
    public void Qb_testExternalSignExamDeadline() throws Exception {
        System.out.println("External Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalAssignExamDeadline(11, "2019-01-29");
    }
    
     @Test
    public void QbR_testExternalSignResitExamDeadline() throws Exception {
        System.out.println("External Resit Exam Deadline set");
        DatabaseHandling instance = new DatabaseHandling();
        instance.externalAssignResitExamDeadline(11, "2019-01-29");
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
  

