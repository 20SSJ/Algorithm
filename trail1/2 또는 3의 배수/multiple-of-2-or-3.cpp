#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    int i = 1;
    while(i <= N){
        if(i % 2 == 0 || i % 3 == 0){
            cout << 1;
        } else cout << 0;
        cout << " ";
        i++;
    }
    return 0;
}