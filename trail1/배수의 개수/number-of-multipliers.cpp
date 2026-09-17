#include <iostream>
using namespace std;

int main() {
    int num, three, five;
    three = five = 0;
    for(int i = 0; i < 10; i++){
        cin >> num;
        if(num % 3 == 0) three++;
        if(num % 5 == 0) five++;
    }
    cout << three << " " << five;
    return 0;
}