//Write a program to determine whether an input string x is a substring of another input string y!

#include <iostream>
#include <string>

using namespace std;

bool hasSubstring(const char *str, const char *find)
{
    if (str[0] == '\0' && find[0] == '\0')
    {
        return true;
    }

    for (int i = 0; str[i] != '\0'; i++)
    {
        bool fondNonMatch = false;
        for (int j = 0; find[j] != '\0'; i++)
        {
            if (str[i + j] != find[j])
            {
                fondNonMatch = true;
                break;
            }
        }
        if (!fondNonMatch)
        {
            return true;
        }
    }
    return false;
}

int main(int argc, char const *argv[])
{
    char str[] = "abate";
    char find[] = "bat";
    cout << hasSubstring(str, find) << endl;
}
