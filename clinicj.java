import java.util.ArrayList;

import java.util.*;

public class clinicc{

public static void main(String args[])
{
Scanner input=new Scanner(System.in);
System.out.println("Enter the number of doctors");
int num_doctors=input.nextInt();
int i=0;
general D[]=new general[10];

for( i=0;i<num_doctors;i++)
{
D[i]=new general();

System.out.println("Enter the type of doctor");
String type=input.next();
if(type.equals("general"))
D[i]=new general();
else if (type.equals("special"))
{
D[i]=new special();
System.out.println("Enter speciality of the doctor");
String speciality=input.next();
D[i].set_specialization(speciality);
}
System.out.println("Enter name of the doctor");
String name=input.next();
D[i].set_name(name);

System.out.println("Enter the leaveinfo of doctor");
String leave=input.next();
D[i].set_leave(leave);

}
while(true)
{
System.out.println("Enter the name of the patient");
String patient=input.next();
System.out.println("Enter preferred date for check up");
String patient_date=input.next();


System.out.println("press 1 for adding the doctor");
System.out.println("press 2 for a general doctor");
System.out.println("press 3 for a specialized doctor");
System.out.println("press 4 for quit");
int l=input.nextInt();
switch(l)
{
case 1:
int x=num_doctors++;
System.out.println("Enter the type of doctor");
String type=input.next();
if(type.equals("general"))
D[x]=new general();
else if (type.equals("special"))
{
D[x]=new special();
System.out.println("Enter speciality of the doctor");
String speciality=input.next();
D[x].set_specialization(speciality);
}
System.out.println("Enter name of the doctor");
String name=input.next();
D[x].set_name(name);

System.out.println("Enter the leaveinfo of doctor");
String leave=input.next();
D[x].set_leave(leave);


break;
case 2: System.out.println("The avaliable doctors are");
int flag=0;
for( i=0;i<num_doctors;i++)
{ 
String temp=D[i].get_specialization();
if(temp.equals("NO"))
	{
		String name_d=D[i].get_name();
		System.out.println(name_d);
	}
}
System.out.println("Please choose the doctor");
String name_in=input.next();

for( i=0;i<num_doctors;i++)
{
String temp1=D[i].get_name();
if(name_in.equals(temp1))
{
String temp2=D[i].get_leave();
if(!temp2.equals(patient_date))
{
D[i].addPatientToConsultationQueue(patient);
D[i].display_consultant();
}
else
{
System.out.println("You're being refereed to a special doctor");
flag=1;
}
break;
}


}

System.out.println("");
if(flag==1)
{
System.out.println("The avaliable special Doctors are");
for(i=0;i<num_doctors;i++)
{ String name_dp = null;
String temp=D[i].get_specialization();
if(!temp.equals("NO")){
name_dp=D[i].get_name();
System.out.println(name_dp);
}
}
String name_inp=input.next();



for(i=0;i<num_doctors;i++)
{
String temp1=D[i].get_name();
if(name_inp.equals(temp1))
{
String temp2=D[i].get_leave();
if(!temp2.equals(patient_date))
{
D[i].addPatientTofollowUpQueue(patient);
D[i].display_followup();

}
else
{
System.out.println("Please choose another date");
D[i].addPatientTofollowUpQueue(patient);
D[i].display_followup();

}
break;
}

}

}


System.out.println("Thank you");

break;
case 3:System.out.println("The avaliable doctors are");

for( i=0;i<num_doctors;i++)
{ String name_dp = null;
String temp=D[i].get_specialization();
if(!temp.equals("NO")){
name_dp=D[i].get_name();
System.out.println(name_dp);}
}
String name_inp=input.next();

for( i=0;i<num_doctors;i++)
{
String temp1=D[i].get_name();
if(name_inp.equals(temp1))
{
String temp2=D[i].get_leave();
if(!temp2.equals(patient_date))
{
D[i].addPatientToConsultationQueue(patient);
D[i].display_consultant();
}
else
{
System.out.println("Please choose another date :");
D[i].addPatientTofollowUpQueue(patient);
D[i].display_followup();
D[i].display_consultant();
}
break;
}

}
System.out.println("Thank you");

break;
case 5:System.exit(0);
}

}
}



}
class general
{
private String name;
private String fee;
private String  leaveinfo;
private String special="NO";
ArrayList <String> consultant=new ArrayList<String>();

void set_name(String nam)
{
this.name=nam;
}
public void addPatientTofollowUpQueue(String patient) {
// TODO Auto-generated method stub

}
void set_specialization(String speciality) {

}
String get_specialization()
{
return special;
}

String get_name() {
return name;
}
void set_leave(String leav)
{
this.leaveinfo=leav;
}

String get_leave() {
return leaveinfo;
}


void addPatientToConsultationQueue(String name){
consultant.add(name);
System.out.println("Patient added to the consultation up queue");
}
void updateLeaveInfo(String leave) {
this.leaveinfo=leave;

}
void consult(String nam) {
System.out.println(nam+" has been consluted by "+this.name);

}
void display_followup()
{
// for (int i=0; i<follow.size(); i++)
   //          System.out.print(follow.get(i)+" ");
}
void display_consultant()
{
System.out.println("THE PATIENTS IN THE CONSULTATION QUEUE OF "+this.name+" ARE  ");
for (int i=0; i<consultant.size(); i++)
            System.out.println("The patient name is " +consultant.get(i)+" ");
}
}
class special extends general
{
String name;
String fee;
String leaveinfo;
String specialization;
ArrayList<String> follow=new ArrayList<String>();
ArrayList <String> consultant=new ArrayList<String>();


void set_name(String nam)
{
this.name=nam;
}
String get_name() {
return name;
}
void set_leave(String leav)
{
this.leaveinfo=leav;
}

String get_leave() {
return leaveinfo;
}
void set_specialization(String duty) {
this.specialization=duty;
}
String get_specialization() {
return specialization;
}



void addPatientToConsultationQueue(String name){
consultant.add(name);
System.out.println("Patient added to the consultation up queue");
}

public void addPatientTofollowUpQueue(String name){
follow.add(name);
System.out.println("Patient added to the follow up queue");
}
void updateLeaveInfo(String leave) {
this.leaveinfo=leave;
}
void consult(String nam) {
System.out.println(nam+" has been consluted by "+this.name);

}
void display_followup()
{
System.out.println("THE PATIENTS IN THE FOLLOWUP QUEUE OF "+this.name+" ARE  ");
for (int i=0; i<follow.size(); i++)
            System.out.println("The patient name is " +follow.get(i)+" ");
}
void display_consultant()
{
System.out.println("THE PATIENTS IN THE CONSULTATION QUEUE OF "+this.name+" ARE  ");
for (int i=0; i<consultant.size(); i++)
            System.out.println("The patient name is " +consultant.get(i)+" ");
}
}