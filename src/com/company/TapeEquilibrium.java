package com.company;

public class TapeEquilibrium {
  public int solution(int[] A) {
    // write your code in Java SE 8
    int N = A.length;
    int[] prefix = new int[N];
    prefix[0] = A[0];
    for (int i = 1; i < N; i++) {
      prefix[i] += prefix[i-1] + A[i];
    }
    int min = prefix[N-1];
    for (int j = 0; j < N; j++) {
      int diff = Math.abs(prefix[j] - (prefix[N-1] - prefix[j]));
      min = Math.min(min, diff);
    }
    return min;
  }
}
