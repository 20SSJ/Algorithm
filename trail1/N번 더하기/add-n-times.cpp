#include <iostream>
using namespace std;

int main() {
    int A, N, i = 0;
    cin >> A >> N;
    while(i < N){
        A += N;
        cout << A << "\n";
        i++;
    }
    // Please write your code here.
    return 0;
}