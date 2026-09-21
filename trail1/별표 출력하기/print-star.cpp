#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= i; j++){
            cout << "* ";
        }
        cout << "\n";
    }
    for(int i = 1; i < N; i++){
        for(int j = N - i; j > 0; j--){
            cout << "* ";
        }
        cout << "\n";
    }
    return 0;
}