#include <iostream>
using namespace std;

int main() {
    int N;
    cin >> N;
    string result = (N >= 80) ? "pass" : to_string(80 - N) + " more score";
    cout << result;
    return 0;
}