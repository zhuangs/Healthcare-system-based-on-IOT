/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Employee.Employee;
import Business.Enterprise.CDCEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.Enterprise.EnterpriseType;
import static Business.Enterprise.Enterprise.EnterpriseType.CDC;
import static Business.Enterprise.Enterprise.EnterpriseType.Hospital;
import Business.Enterprise.HospitalEnterprise;
import Business.Manufactrurer.Manufacturer;
import Business.Network.Network;
import Business.Organization.ClinicOrganization;
import Business.Organization.DistributorOrganization;
import Business.Organization.Organization;
import Business.Organization.Organization.OrganizationType;
import static Business.Organization.Organization.OrganizationType.ClinicOrganization;
import Business.Organization.PHDOrganization;
import Business.Role.CDCRole;
import Business.Role.ClinicRole;
import Business.Role.DistributorRole;
import Business.Role.HospitalRole;
import Business.Role.ManufacturerRole;
import Business.Role.NetworkRole;
import Business.Role.PHDRole;
import Business.Role.SysAdminRole;
import Business.UserAccount.UserAccount;

/**
 *
 * @author yufeng
 */
public class ConfigureBusiness {
   
    public static Business Configure(){
        Business business = Business.getInstance();
        Employee employee = business.getEmployeeDirectory().addEmployee();
        UserAccount userAccount = business.getUserAccountDirectory().addUserAccount();
        employee.setFirstname("Yufeng");
        employee.setLastname("Zhang");
        userAccount.setUserName("admin");
        userAccount.setPassword("admin");
        userAccount.setRole(new SysAdminRole());
        userAccount.setEmployee(employee);
        
//        Network network = business.getNetworkDirectory().addNetwork();
//        Employee employeeNetwork = network.getEmployeeDirectory().addEmployee();
//        UserAccount userAccountNetwork = network.getUserAccountDirectory().addUserAccount();
//        network.setNetworkName("China");
//        employeeNetwork.setFirstname("Yufeng");
//        employeeNetwork.setLastname("Zhang");
//        userAccountNetwork.setUserName("network");
//        userAccountNetwork.setPassword("network");
//        userAccountNetwork.setRole(new NetworkRole());
//        userAccountNetwork.setEmployee(employeeNetwork);
//        
//        CDCEnterprise cDCEnterprise = new CDCEnterprise();
//        network.getEnterpriseDirectory().getEnterpriseList().add(cDCEnterprise);
//        Employee employeeCDCEnterprise = ((CDCEnterprise)cDCEnterprise).getEmployeeDirectory().addEmployee();
//        UserAccount userAccountCDCEnterprise = cDCEnterprise.getUserAccountDirectory().addUserAccount();
//        cDCEnterprise.setName("China CDC");
//        employeeCDCEnterprise.setFirstname("Yufeng");
//        employeeCDCEnterprise.setLastname("Zhang");
//        userAccountCDCEnterprise.setUserName("cdc");
//        userAccountCDCEnterprise.setPassword("cdc");
//        userAccountCDCEnterprise.setRole(new CDCRole());
//        userAccountCDCEnterprise.setEmployee(employeeCDCEnterprise);
//        
//        HospitalEnterprise hospitalEnterprise = new HospitalEnterprise();
//        network.getEnterpriseDirectory().getEnterpriseList().add(hospitalEnterprise);
//        Employee employeeHospitalEnterprise = hospitalEnterprise.getEmployeeDirectory().addEmployee();
//        UserAccount userAccountHospital = hospitalEnterprise.getUserAccountDirectory().addUserAccount();
//        hospitalEnterprise.setName("Northeastern University");
//        employeeHospitalEnterprise.setFirstname("Yufeng");
//        employeeHospitalEnterprise.setLastname("Zhang");
//        userAccountHospital.setUserName("hospital");
//        userAccountHospital.setPassword("hospital");
//        userAccountHospital.setRole(new HospitalRole());
//        userAccountHospital.setEmployee(employeeHospitalEnterprise);
//        
//        
//        ClinicOrganization clinicOrganization = new ClinicOrganization();
//        hospitalEnterprise.getOrganizationDirectory().getOrganizationList().add(clinicOrganization);
//        Employee clinicEmployee = clinicOrganization.getEmployeeDirectory().addEmployee();
//        UserAccount userAccountClinic = clinicOrganization.getUserAccountDirectory().addUserAccount();
//        clinicOrganization.setName("Northeastern Clinic");
//        clinicEmployee.setFirstname("Yufeng");
//        clinicEmployee.setLastname("Zhang");
//        userAccountClinic.setUserName("clinic");
//        userAccountClinic.setPassword("clinic");
//        userAccountClinic.setRole(new ClinicRole());
//        userAccountClinic.setEmployee(clinicEmployee);
//        
//        PHDOrganization pHDOrganization = new PHDOrganization();
//        cDCEnterprise.getOrganizationDirectory().getOrganizationList().add(pHDOrganization);
//        Employee PHDemployee = pHDOrganization.getEmployeeDirectory().addEmployee();
//        UserAccount PHDuserAccount = pHDOrganization.getUserAccountDirectory().addUserAccount();
//        pHDOrganization.setType("PHD");
//        pHDOrganization.setName("Mass PHD");
//        PHDemployee.setFirstname("Yufeng");
//        PHDemployee.setLastname("Zhang");
//        PHDuserAccount.setUserName("phd");
//        PHDuserAccount.setPassword("phd");
//        PHDuserAccount.setRole(new PHDRole());
//        PHDuserAccount.setEmployee(PHDemployee);
//        
//        DistributorOrganization distributorOrganization = new DistributorOrganization();
//        cDCEnterprise.getOrganizationDirectory().getOrganizationList().add(distributorOrganization);
//        Employee distributorEmployee = distributorOrganization.getEmployeeDirectory().addEmployee();
//        UserAccount distributorUserAccount = distributorOrganization.getUserAccountDirectory().addUserAccount();
//        distributorOrganization.setName("Distributor");
//        distributorOrganization.setType("Distributor");
//        distributorEmployee.setFirstname("Yufeng");
//        distributorEmployee.setLastname("Zhang");
//        distributorUserAccount.setUserName("distributor");
//        distributorUserAccount.setPassword("distributor");
//        distributorUserAccount.setRole(new DistributorRole());
//        distributorUserAccount.setEmployee(distributorEmployee);
//        
//        Manufacturer manufacturer = (Manufacturer) network.getEnterpriseDirectory().addEnterprise(EnterpriseType.Manufacturer);
//        Employee mEmployee = manufacturer.getEmployeeDirectory().addEmployee();
//        UserAccount muserAccount = manufacturer.getUserAccountDirectory().addUserAccount();
//        manufacturer.setName("Manufacuturer");
//        mEmployee.setFirstname("Yufeng");
//        mEmployee.setLastname("Zhang");
//        muserAccount.setUserName("Manufacturer");
//        muserAccount.setPassword("Manufacturer");
//        muserAccount.setEmployee(mEmployee);
//        muserAccount.setRole(new ManufacturerRole());
        
        return business;
    }
}
