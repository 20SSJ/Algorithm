#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    int value = 1;
    while(value <= N){
        cout << value++ << " ";
    }
    return 0;
}