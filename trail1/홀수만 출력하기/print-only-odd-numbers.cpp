#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    while(N--){
        int num;
        cin >> num;
        if(num % 2 != 0 && num % 3 == 0){
            cout << num << "\n";
        }
    }
    return 0;
}