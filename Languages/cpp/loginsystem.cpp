#include<iostream>
#include<fstream>
using namespace std;

//TODO Split into better methods

int main()
{
    string command,
    name, password, //the ones that are found in the file
    inName, inPassword, //the ones you are going to input from keyboard
    registerName, registerPassword; //also what you're going to input

    while (1)
    {
        cout<<"(register/exit/login)\n"
            <<"Command: ";
        getline(cin, command);

        if (command=="exit") //(for C strings) if (!strcmp(command, "exit"))
        {
            return 1;
        }
        if (command=="register") //(for C strings) if (!strcmp(command, "register"))
        {
            //TODO change to non ofstream (concrete file)
            ofstream g("registration.txt"); 
            if (!g.is_open())
            {
                cout<<"could not open file\n";
                return 0;
            }
            cout<<"\n\n\n" <<"New Username: ";
            getline(cin, registerName); //input from keyboard will go into registerName
            cout<<"New Password: ";
            getline(cin, registerPassword); //input from keyboard will go into registerPassword
            g << registerName <<'\n' << registerPassword;
            g.close();
        }
        if (command=="login")
        {
            ifstream f("registration.txt");
            if (!f.is_open()) 
            {
                cout<<"could not open file\n"; 
                return 0;
            }
            getline(f, name, '\n'); //reads the user name from file f (which is using "registration.txt")
            getline(f, password, '\n'); //reads the password from file f (which is using "registration.txt")
            f.close();

            //login
            while (1)
            {
                //you are going to input the name and password here
                cout<<"\n\n\n"
                    <<"Enter Username: ";
                getline(cin, inName);
                cout<<"Enter Password: ";
                getline(cin, inPassword);
                if (inName==name && inPassword==password)
                {
                    cout<<"Login Successful\n" << "Welcome, "<<inName <<'\n';
                    break;
                }
                cout<<"incorrect name or password\n"; 
            }
            cout << "check1";
            //TODO now do something about the account
            system("PAUSE");
        }
        cout<<"\n\n\n\n\n"; 
    }
    cout << "check2";
    
    return 1;
}