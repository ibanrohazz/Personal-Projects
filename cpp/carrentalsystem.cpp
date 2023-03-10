#include <iostream>
#include <conio.h>
#include <stdlib.h>

using namespace std;

// Basic struct for cars
struct Cars 
{
    string make [20] = { "Subaru", "Honda", "Toyota", "Ford", "Chevrolet", "Nissan", "Dodge", "Jeep", "Hyundai", "Kia", "Mazda", "BMW", "Mercedes", "Audi", "Volkswagen", "Porsche", "Lexus", "Infiniti", "Volvo", "Acura" };
    string model [20] = { "Impreza", "Civic", "Corolla", "Fiesta", "Cruze", "Sentra", "Charger", "Wrangler", "Elantra", "Soul", "3", "3 Series", "C-Class", "A4", "Jetta", "911", "IS", "Q50", "S60", "TLX" };
    string color [10] = { "Red", "Blue", "Green", "Yellow", "Black", "White", "Silver", "Gray", "Brown", "Orange" };
    int price [10] = { 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000 };
    int year [20] = { 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008, 2009, 2010, 2011, 2012, 2013, 2014, 2015, 2016, 2017, 2018, 2019 };
};

struct Users 
{
    string Name [10];
    string ID [10];
    int payment_id [10];
};

// declaring struct
Cars car;
Users user;

//create a basic login method 
int login()
{
    string pass ="";
    
}


int main()
{

}