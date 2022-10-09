package com.example.caesarcipher;

public class utility {

    // Declaration of all the required variables
    private static String alphabet = "A´B@C#D$E%F*G!H&IJ?K<L>M;N-O_P~Q`R,S+T=U^V—W©X®Y℗Z";
    private static int index;
    private static int updated_index;
    private static int final_index;
    private static int index_p_t_l;
    private static int index_s_t_l;
    private static String plainTxt;
    private static String cipherTxt;
    private static String finalTxt;

    // code for encryption
    public static String encrypt1(String plaintext, int encrptionKey) {
        reset();
        // plaintext is converted to uppercase
        // so that it is easy to convert according
        // to Caesar Cipher algorithm
        plaintext = plaintext.toUpperCase();
        // using a for loop the use index and
        // change text with help of it
        for (index = 0; index < plaintext.length(); index++) {
            // checking the condition for plaintext to be
            // null at some character position
            if (plaintext.charAt(index) != ' ') {
                index_p_t_l = alphabet.indexOf(plaintext.charAt(index));
                // index is being updated
                // so that next and final index
                // be used for ciphertext
                updated_index = encrptionKey + alphabet.indexOf(plaintext.charAt(index));
                if (updated_index >= alphabet.length()) {
                    final_index = updated_index - alphabet.length();
                } else
                    final_index = updated_index;
                // substring is used so that every character
                // can be separately converted to ciphertext
                cipherTxt = alphabet.substring(final_index, final_index + 1);
                finalTxt = finalTxt + cipherTxt;
            }
        }
        // returning the
        // final changed text
        return finalTxt;
    }

    // code for decryption
    public static String decrypt1(String ciphertext, int decryptionKey) {
        reset();
        ciphertext = ciphertext.toUpperCase();
        // using a for loop the use index and
        // change text with help of it
        for (index = 0; index < ciphertext.length(); index++) {
            if (ciphertext.charAt(index) != ' ') {
                index_p_t_l = alphabet.indexOf(ciphertext.charAt(index));
                index_s_t_l = index_p_t_l;
                // index is updated with help of decryption
                // key which we provided as input
                updated_index = alphabet.indexOf(ciphertext.charAt(index)) - decryptionKey;
                if (updated_index < 0) {
                    final_index = updated_index + alphabet.length();
                } else
                    final_index = updated_index;
                // reverse of encryption is done as
                // substring here is used to convert
                // each ciphertext character to plaintext
                plainTxt = alphabet.substring(final_index, final_index + 1);
                finalTxt += plainTxt;
            }
        }
        // returning the
        // final changed text
        return finalTxt;
    }

    // method to reset the text
    // in the output textview
    private static void reset() {
        finalTxt = " ";
    }
}
