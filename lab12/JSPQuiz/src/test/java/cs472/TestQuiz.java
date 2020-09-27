/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cs472;

//import app.Quiz;

import app.Quiz;
import org.junit.*;

import static org.junit.Assert.*;


/**
 * @author levi
 * JUnit test for the TestQuiz class.  Basic verification tests that all pass as of 4/8/09.
 * @since 4/8/09
 */
public class TestQuiz {
    Quiz quizUnderTest = new Quiz();

    public TestQuiz() {

    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}

    @Test
    public void testIsCorrect() {
        /* should be at first question, answer should be "9" */
        assertTrue("first question answer should be '9'", quizUnderTest.isCorrect("9"));
    }


    @Test
    public void testGetNumberCorrect() {
        /* should be at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());

        quizUnderTest.markAnswerCorrect(); //should increment the score and the current question number
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex());

    }

    /**
     * processAnswer is a special method that sets state in processing the input answer and then
     * returns a string indicating which page to navigate to next.  This method should be used by clients.
     * It will call markAnswerCorrect if the correct answer has been given to the quiz.
     * Precondition:  setUserAnswer should have been called before this.
     * 2/2/2020kl
     */
    @Test
    public void testProcessAnswer(){
        /* should be at first question, answer should be 0 */
        assertEquals(0, quizUnderTest.getNumCorrect());

        quizUnderTest.setUserAnswer("9"); // correct answer for first question
        quizUnderTest.processAnswer();
        assertEquals(1, quizUnderTest.getNumCorrect());
        assertEquals(1, quizUnderTest.getCurrentQuestionIndex());

    }
}