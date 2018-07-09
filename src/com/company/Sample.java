package com.company;

public class Sample {

  public int solution(int[] A) {
    // if only one element, no need to rotate
    int N = A.length;
    if (N == 1) {
      return 0;
    }
    // Worst case is every six-sided die moves at most 2 steps to its opposite,
    // then the total steps for the worst case would be num of die * 2
    int minimumSteps = N * 2;
    int cur_number = 1;
    // iterate each potential target [1..6] and count total moves for all
    // cubes to move to the target
    while (cur_number <= 6) {
      int current = 0;
      for (int j = 0; j < N; j++) {
        int move = 0;
        if (A[j] + cur_number == 7) {
          move = 2;
        } else if (A[j] == cur_number) {
          move = 0;
        } else {
          move = 1;
        }
        current += move;
      }
      if (minimumSteps > current) {
        minimumSteps = current;
      }
      cur_number++;
    }
    return minimumSteps;
  }

  public static void main(String[] args) {

  }
}
