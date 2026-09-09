#include <iostream>
using namespace std;

int main() {
    int score;
    cin >> score;
    string res = (score == 100) ? "pass" : "failure";
    cout << res;
    return 0;
}