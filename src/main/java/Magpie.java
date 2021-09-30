import java.util.Locale;

/**
 * A program to carry on conversations with a human user.
 * This is the initial version that:  
 * <ul><li>
 *       Uses indexOf to find strings
 * </li><li>
 *          Handles responding to simple words and phrases 
 * </li></ul>
 * This version uses a nested if to handle default responses.
 * @author Laurie White
 * @version April 2012
 */
public class Magpie
{
    /**
     * Get a default greeting   
     * @return a greeting
     */
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }
    
    /**
     * Gives a response to a user statement
     * 
     * @param statement
     *            the user statement
     * @return a response based on the rules given
     */
    public String getResponse(String statement)
    {
        String response = "";
        if (findWord(statement,"no") >= 0)
        {
            response = "Why so negative?";
        } else if (statement.toLowerCase(Locale.ROOT).indexOf("i want to") >= 0 ) {
            response = transformIWantToStatement(statement);
        }else if (statement.toLowerCase(Locale.ROOT).indexOf("i want ") >= 0) {
            response = transformIWantStatement(statement);
        }else if (statement.toLowerCase(Locale.ROOT).indexOf("do you ") >= 0 && statement.toLowerCase(Locale.ROOT).indexOf(" me") >= 0) {
            response = transformIWantStatement(statement);
        }else if (statement.toLowerCase(Locale.ROOT).indexOf("i ") >= 0 && statement.toLowerCase(Locale.ROOT).indexOf(" you") >= 0) {
            response = transformIYouStatement(statement);
        }else
        if (findWord(statement,"dog") >= 0 || statement.indexOf("cat") >= 0)
        {
            response = "Tell me more about your pets";
        } else
        if (findWord(statement,"Nathan") >= 0)
        {
            response = "Best tech support guy ever!";
        }
        else
        if (findWord(statement,"lazy") >= 0)
        {
            response = "Ur so cool :)";
        }else
        if (findWord(statement,"use") >= 0)
        {
            response = "wtf why";
        }
        else
        if (statement.trim().length() == 0)
        {
            response = "Why you bully me, tell me something :(.";
        }
        else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }
    
    /**
     * Pick a default response to use if nothing else fits.
     * @return a non-committal string
     */
    public String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int)(r * NUMBER_OF_RESPONSES);
        String response = "";
        
        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "I don't care about what your saying. LEAVE ME ALONE!";
        }
        else if (whichResponse == 5)
        {
            response = "Aww really, so cute! I love random responses";
        }
    
        return response;
    }

    // Checks to see if the String word appears as a whole word
    // in the String str (in this case, a "whole word" means that 
    // word is not just a substring of some larger word in str)

    // This method should work regardless of the capitalization 
    // of str or word

    // The method returns the index of the first character in word
    // if it is found, and returns -1 otherwise. 
    public int findWord(String str, String word) {


        int index = str.toLowerCase(Locale.ROOT).indexOf(word.toLowerCase(Locale.ROOT));

        if (!(index+word.length() == str.length()) && ((str.charAt(index+word.length()) > 'a' && str.charAt(index+word.length()) < 'z') || (str.charAt(index+word.length()) > 'A' && str.charAt(index+word.length()) < 'Z'))) {
            return -1;
        }
        if (!(index-1 == -1) && ((str.charAt(index-1) > 'a' && str.charAt(index-1) < 'z') || (str.charAt(index-1) > 'A' && str.charAt(index-1) < 'Z'))) {
            return -1;
        }
        return index;
    }


    // We will work on the following methods later!

    /**
     * Take a statement with "I want <something>." and transform it into 
     * "Would you really be happy if you had <something>?"
     * @param statement the user statement, assumed to contain "I want"
     * @return the transformed statement
     */
    public String transformIWantStatement(String statement)
    {
        //your code here
        return "Would you really be happy if you had "+statement.toLowerCase(Locale.ROOT).replaceAll("i want ","")+"?";
    }

    /**
     * Take a statement with "I <something> you" and transform it into 
     * "Why do you <something> me?"
     * @param statement the user statement, assumed to contain "I" followed by "you"
     * @return the transformed statement
     */
    public String transformIYouStatement(String statement)
    {
        //your code here
        return "Why do you "+statement.toLowerCase(Locale.ROOT).replace("i ", "").replaceAll(" you","")+" me?";
    }

    /**
     * Take a statement with "I want to <something>." and transform it into 
     * "What would it mean to <something>?"
     * @param statement the user statement, assumed to contain "I want to"
     * @return the transformed statement
     */
    public String transformIWantToStatement(String statement)
    {
        // your code here
        return "What would it mean to "+statement.toLowerCase(Locale.ROOT).replaceAll("i want to ","")+"?";
    }




    /**
     * Take a statement with "you <something> me" and transform it into 
     * "What makes you think that I <something> you?"
     * @param statement the user statement, assumed to contain "you" followed by "me"
     * @return the transformed statement
     */
    public String transformYouMeStatement(String statement)
    {
        // your code here
        return "What makes you think that I "+statement.toLowerCase(Locale.ROOT).replace("do you ", "").replaceAll(" me","")+" you?";
    }
}
