package org.example.pilotfeedbackservice.utils;

public class RatingUtils {
    /**
     *
     * @param feedback - Indicates the rating of the user or pilot
     * @return - Changing the user's overall rating
     */
    public static int getRatingChange(int feedback){
        /**
         * This formula describes the behavior of the rating system:
         *
         *  * If the score is 1-2, then the rating of the person who was given this score
         *  will decrease by this value.
         *  * If the score is 3, then the rating of the person will not change in any way.
         *  * If the score is from 4-5, then the rating will increase by 1-2, respectively.
         */
        return feedback - 3;
    }
}
