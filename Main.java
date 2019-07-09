package com.company;

public class Main {

    public static void main(String[] args) {
        //Delimiters used in the CSV file
        private static final String COMMA_DELIMITER = ",";

        public static void main(String args[])
        {
            BufferedReader br = null;
            try
            {
                //Reading the csv file
                br = new BufferedReader(new FileReader("Employee.csv"));

                //Create List for holding Score objects
                List<Scores> scoreList = new ArrayList<Scores>();

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
                        Scores score = new Scores(Integer.parseInt(retrieveScores[0]),
                                retrieveScores[1],
                                Integer.parseInt(retrieveScores[2]));
                        scoreList.add(score);
                    }
                }

                //Lets print the Score List
                double web = 1.0;
                double email = 1.2;
                double social = 1.5;
                double webinar = 2.0;
                for(Scores e : scoreList)
                {
                    System.out.println(e.getContactId()+"   "+e.getEvent()+"   "
                            +e.getScore());

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
                int counter = 0;
                for(Scores e : scoreList)
                {
                    counter+=e.getContactId();
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