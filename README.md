Problem.
The goalhere is to buildahypothetical scoringengine for sales leads.Thehigher the score,the
hotter the lead. Your application will be run fromthe command-line and will accept a csv file path
as input.Your csv file input will have the following layoutfor eachline:
contactid-integer
event- string
score -decimal
Example:
1, web, 34.33
1, email, 3.4
1,email,4
2, webinar, 55.4
2, social, 15
Each line in the csv file indicates that a particular contact engaged with a particular event. Each line
alsoprovides a score representingan assessmentofthe contact’s levelofengagement withthat
particular event.In the case above,the first record shown indicates that contact 1,generateda
webevent, andthis interaction was assigneda score of34.33. There will be manyeventsper
contact, and a contact may interact with a particular eventtype more than once.
The available eventtypes are as follows:
web
email
social
webinar
Each eventtype has an associated weightindicatingthe importanceofthis eventto a sales lead’s
engagement:
web 1.0
email 1.2
social 1.5
webinar 2.0

In order to score a particular contact, we will use the following algorithm:
1) Contact event scores willfirst be weightedbyeventtype:
web = score * 1.0
email = score * 1.2
social = score * 1.5
webinar = score * 2.0
2) All scores willthen be summed by contactidto getthe total score for each contact.
3) The summed scores shouldthen be normalizedon a scaleof0to 100. To normalize
the summed scores you willtake the highest and lowest summedscores found
acrossall contactsmakingthose100and0respectivelyandinterpolatethe
remaining summed scores in-between. Roundthe summed scores tothe closest
integer.
4) Finally, contacts shouldbe labelledbyquartile basedonthenormalizedscore:
Q3< normalizedscore<=100->platinum
Q2< normalizedscore <= Q3 -> gold
Q1 < normalized score <= Q2 -> silver
0 <=normalizedscore <=Q1 ->bronze
Note:quartiles will needto be calculated,do not assume an even distribution.
5) The output of your application shouldbe writtentothe console withthe following
format:
contactid,quartilelabel,normalizedscore
Example output:
1, silver, 44
2, platinum, 99
Notes.
Pleasesubmitthefollowing:
1) Yoursourcecode.
2) Automated unittests or inputfiles to demonstrate howyou unittestedyour
solution.
