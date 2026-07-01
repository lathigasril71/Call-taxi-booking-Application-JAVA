import java.io.*;
import java.util.*;
class NoServiceException extends Exception
{
String msg;

NoServiceException()
{
super();
}

NoServiceException(String msg)
{
super(msg);
this.msg = msg;
}

public String toString()
{
return "NoServiceException:"+msg;
}
}

class Taxi
{
int taxiNo,bkID,cID;
char from='A',to='A';
int pkTime,dTime;
double amount ,earnings;

Taxi()
{
}

Taxi(int taxiNo)
{
this.taxiNo=taxiNo;
}


Taxi(Taxi t)
{
taxiNo = t.taxiNo;
bkID = t.bkID;
cID = t.cID;
from = t.from;
to = t.to;
pkTime = t.pkTime;
dTime = t.dTime;
amount =t.amount;
earnings = t.earnings;
}


public String toString()
{
return bkID+"\t"+cID+"\t"+from+"\t"+to+"\t"+pkTime+"\t"+dTime+"\t"+amount;
}
}


class CallTaxiApp
{
Taxi at;
List<Taxi> list;
List<Taxi> trips = new ArrayList<>();
char fpoint,topoint;
int PKTime;
static int bkID = 10234;
static int cID  = 10343;

CallTaxiApp(int n)
{
list = new ArrayList<>(n);
Taxi t[] = new Taxi[n];
for(int i=0;i<n;i++)
{
t[i] = new Taxi(i+1);
list.add(t[i]);
}
}

Boolean check(char pt)
{
return (pt =='A'||pt =='B'||pt =='C'||pt =='D'||pt =='E'||pt =='F');
}

Taxi findLowEarn(List<Taxi>avail)
{
Taxi min = null;
for(Taxi k:avail)
if(k.dTime<=PKTime)
min = k;
if(min !=null)
for(Taxi k:avail)
if(k.earnings<=min.earnings)
min =k;
return min;
}

Taxi findLowDist(List<Taxi>avail)
{
int min =0;
Taxi mt = null;
for(Taxi k:avail)
if(k.dTime<=PKTime)
{
min = Math.abs(k.to-fpoint);
mt =k;
}
if(mt !=null)
for(Taxi k:avail)
{
int kmin = Math.abs(k.to -fpoint);
if(kmin <min)
{
min = kmin;
mt =k;
}
}

return mt;
}



void booking()throws Exception
{
at = null;

BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter form,to &pickup time:");
fpoint = br.readLine().charAt(0);
if(!(check(fpoint)))
throw new NoServiceException("Invalid from point");
topoint = br.readLine().charAt(0);
if(!(check(topoint)))
throw new NoServiceException("Invalid to point");
PKTime = Integer.parseInt(br.readLine());
List<Taxi> avail = new ArrayList<>();
for(Taxi k:list)
if(k.to == fpoint && k.dTime<=PKTime)
avail.add(k);
if(avail.size() >0)
at = new Taxi(findLowEarn(avail));
else
{
for(Taxi k:list)
if(k.dTime<=PKTime)
avail.add(k);
if(avail.size() >0)
at = new Taxi(findLowDist(avail));
}
if(at ==null)
throw new NoServiceException("No Taxi avilable");
System.out.println("Taxi can be alloted");
System.out.println("Taxi-"+at.taxiNo+" is alloted");
at.bkID = bkID++;
at.cID = cID++;
at.from = fpoint;
at.to = topoint;
at.pkTime = PKTime;
at.dTime = PKTime +Math.abs(fpoint-topoint);
at.amount = 100+(((at.dTime - at.pkTime)*15)-5)*10;
at.earnings = at.earnings+at.amount;

trips.add(at);

for(Taxi k:list)
if(k.taxiNo == at.taxiNo)
{
list.remove(k);
break;
}

list.add(at);

}

void disp()
{
for(Taxi k:list)
if(k.earnings>0)
{
System.out.println("Taxi No-"+k.taxiNo+"\t"+"Total Earnings:"+k.earnings);
dispAll(k);
}
}

void dispAll(Taxi t)
{
for(Taxi k:trips)
if(k.taxiNo == t.taxiNo)
System.out.println(k);
}
}

class TaxiDriver
{
public static void main(String arg[])throws Exception
{
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
System.out.println("Enter No. of Taxies:");
int n= Integer.parseInt(br.readLine());
CallTaxiApp cta =new CallTaxiApp(n);
int ch=0;
do
{
try
{
System.out.println("Welcome To Simren Taxi");
System.out.println("Booking -------1");
System.out.println("Display -------2");
System.out.println("Exit--- -------3");
System.out.println("Enter your choice:");
ch =Integer.parseInt(br.readLine());
switch(ch)
{
case 1:
cta.booking();
break;
case 2:
cta.disp();
break;
case 3:
break;
default :
System.out.println("Invalid choice");
}
}catch(Exception ie)
{
System.out.println(ie);
}
}while(ch!=3);
}
}






