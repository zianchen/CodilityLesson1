package com.company;

public class MaxChunksToSort {

  public int solution(int[] A) {
      // no need to do sanity check (A is NULL or A.length == 0) since we have
      // the assumption that N >= 1
      int N = A.length;
      int[] maxLeftPrefix = new int[N];
      int[] minRightSuffix = new int[N];

      // initialization
      maxLeftPrefix[0] = A[0];
      minRightSuffix[N - 1] = A[N - 1];

      for (int i = 1; i < N; i++) {
        maxLeftPrefix[i] = Math.max(maxLeftPrefix[i - 1], A[i]);
      }

      for (int j = N - 2; j >= 0; j--) {
        minRightSuffix[j] = Math.min(minRightSuffix[j + 1], A[j]);
      }

      int res = 0;

      // for a potential split point k, if all elements in the left
      // (cap by maxLeftPrefix[k]) is smaller than or equal to all the elements
      // in the right (should above minRightSuffix[k+1]), then we get a chunk
      for (int k = 0; k < N - 1; k++) {
        if (maxLeftPrefix[k] <= minRightSuffix[k + 1]) {
          res++;
        }
      }
      return res + 1;
  }

  public static void main(String[] args) {

  }
}
