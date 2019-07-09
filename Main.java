package com.company;

public class scoringEngine
{
        private int contactId;
        private String event;
        private int score;

        public scoringEngine(int contactId, String event, int score) {
            super();
            this.contactId = contactId;
            this.event = event;
            this.score = score;
        }

        public int getContactId() {
            return contactId;
        }
        public void setContactId(int contactId) {
            this.contactId = contactId;
        }
        public String getEvent() {
            return event;
        }
        public void setEvent(String event) {
            this.event = event;
        }
        public String getScore() {
            return score;
        }
        public void setScore(String score) {
            this.score = score;
        }

        @Override
        public String toString() {
            return "Score [contactID=" + contactId + ", event=" + event
                    + ", score=" + score + "]";
        }

    public static void main(String[] args) {
        //Delimiters used in the CSV file
        String COMMA_DELIMITER = ",";

            BufferedReader br = null;
            try
            {
                //Reading the csv file
                br = new BufferedReader(new FileReader("\Users\Sidney Elie-Pierre\Desktop"));

                //Create List for holding Score objects
                List<Scores> interactions = new ArrayList<Scores>();

                String line = "";
                //Read to skip the header
                br.readLine();
                //Reading from the second line
                while ((line = br.readLine()) != null)
                {
                    String[] retrieveScores = line.split(COMMA_DELIMITER);

                    if(retrieveScores.length > 0 )
                    {
                        //Save the score details in Score object
                        Scores score = new Scores(retrieveScores[0],
                                retrieveScores[1], retrieveScores[2]);
                        interactions.add(score);
                    }
                }


                //Lets print the Score List
                for(Scores e : interactions)
                {
                    System.out.println(e.getContactId()+"   "+e.getEvent()+"   "+e.getScore());

                    if(e.getEvent() == "web") {
                        scoreList(e) *= web;
                    }
                    else if(e.getEvent() == "email")
                    {
                        scoreList(e) *= email;
                    }
                    else if(e.getEvent() == "social")
                    {
                        scoreList(e) *= social;
                    }
                    else if(e.getEvent() == "webinar")
                    {
                        scoreList(e) *= webinar;
                    }
                    else
                        {
                        scoreList(e) = 0;
                    }
                }
                //Not sure what I am trying to do here
                int counter = 0;
                for(Scores e : scoreList) {
                    //Summing the scores for contactId 1
                    if (e == 1) {
                        score +=
                        counter += e.getContactId();
                    }
                }



            }
            catch(Exception ee)
            {
                ee.printStackTrace();
            }
            finally
            {
                try
                {
                    br.close();
                }
                catch(IOException ie)
                {
                    System.out.println("Error occured while closing the BufferedReader");
                    ie.printStackTrace();
                }
            }
        }
    }