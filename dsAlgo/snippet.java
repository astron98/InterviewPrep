public static class snippet {

  public static fastReader(BufferedReader br) {

    // The try block runs when both input and output files
    // are present in the specified directory.
    try {

      // We modify the input stream to take input
      //from the  input.txt file
      br = new BufferedReader(new FileReader("../input.txt"));

      // We modify the output stream to print the output
      // in the output.txt file
      PrintStream out = new PrintStream(new FileOutputStream("../output.txt"));

      System.setOut(out);
    }

    // In case the input or the output file is not found,
    // a FileNotFoundException is thrown and we enter the
    // catch block.

    // Catch block to handle th exception
    catch (Exception e) {

      // Since an input file is not present, we take input
      // from the usual system input stream.
      br = new BufferedReader(
        new InputStreamReader(System.in));
    }
  }
}