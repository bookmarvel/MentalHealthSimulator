
# Mental Health Simulator

A  simple simulator where you have to complete tasks (go to work, do schoolwork, etc) while also balancing money, food, and mental health.

## Running
Running the project requires Java and the Maven build system to be installed on your system
1. Clone the repo to your computer
2. Compile with `mvn compile`
3. Run with `mvn exec:java`

## Playing the game
The goal of the game is to complete all your tasks for the week without letting your mental health meter, food meter or money run out.  

Each days lasts from 6:00am to 12:00 am the next day, or can be ended early with the go to sleep button. There is a mental health penalty for going to sleep after 10:00pm  

To complete a task hit the corresponding button. Each task takes set amount of time shown on the button, and may also take or give money.  

Orange button tasks are mandatory, and a set minimum number of each must be completed in the week, to avoid a score penalty. These tasks cost both mental health and food.  

Blue button tasks restore mental health at the cost of food.

Red button tasks restore food at the cost of money.
