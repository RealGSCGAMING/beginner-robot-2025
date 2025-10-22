# FRC Robot Simulator Practice - Team 2658

## 🎯 Purpose
This is a practice project for learning Java basics. You'll simulate a robot doing something during a match using variables, loops, and conditionals.

## 🤖 About This Project
This is a **console application** - it runs in your terminal and prints text output. No robot framework needed! This helps you learn Java fundamentals before working with real robot code.

## 📚 What You'll Learn
- Variables (int, double, String, boolean)
- For loops (to simulate time passing)
- If statements (to make decisions)
- Print statements (to show what's happening)
- Basic program structure

## ✅ Your Task
Open `RobotSim.java` and complete these TODOs:

### 1. Create Variables
Add variables to track robot information. Ideas:
```java
int batteryLevel = 100;           // Battery starts at 100%
double distanceTraveled = 0.0;    // Distance in feet
int gamePiecesCollected = 0;      // Number of game pieces
String robotState = "IDLE";       // Current state
int matchTime = 15;               // 15 second autonomous period
```

### 2. Create a Simulation Loop
Use a for loop to simulate time passing (e.g., 15 seconds for autonomous period):
```java
for (int second = 0; second <= 15; second++) {
    System.out.println("Time: " + second + "s");
    // Your simulation logic here
}
```

### 3. Add Logic Inside the Loop
Make things happen! Ideas:
- Battery drains over time: `batteryLevel -= 2;`
- Robot moves: `distanceTraveled += 3.5;`
- Collect game pieces at certain times
- Change robot state based on conditions
- Print updates each second

### 4. Add If Statements
Make decisions based on conditions:
```java
if (batteryLevel < 20) {
    System.out.println("⚠️  WARNING: Low battery!");
}

if (second == 5) {
    robotState = "SCORING";
    gamePiecesCollected++;
}
```

### 5. Add User Input
Add a Scanner to get user input for robot actions:
```java
Scanner scanner = new Scanner(System.in);
System.out.println("Enter action (move, score, stop): ");
String action = scanner.nextLine();
```

### 6. Print Final Statistics
After the loop, show the results:
```java
System.out.println("Final Battery: " + batteryLevel + "%");
System.out.println("Distance Traveled: " + distanceTraveled + " feet");
System.out.println("Game Pieces Scored: " + gamePiecesCollected);
```

## 🚀 How to Run

### Compile the Program
```bash
javac RobotSim.java
```

### Run the Program
```bash
java RobotSim
```

## 💡 Simulation Ideas

Here are some creative ideas for your simulation:

### Idea 1: Autonomous Period Simulation
- Simulate a 15-second autonomous period
- Robot starts IDLE, then MOVES to scoring position
- Scores game pieces at specific times
- Battery drains as robot operates
- Print position updates

### Idea 2: Battery Management
- Start with 100% battery
- Different actions drain different amounts (moving = 2%, scoring = 5%)
- If battery < 20%, print warning
- If battery reaches 0, robot stops

### Idea 3: Distance and Movement
- Track distance traveled in feet
- Robot moves at 3.5 feet per second
- Print position updates
- Calculate if robot reached target distance

### Idea 4: Game Piece Collection
- Robot collects game pieces at certain times
- Each piece takes 2 seconds to collect
- Track total pieces collected
- Print when each piece is scored

### Idea 5: Multiple States
Create different robot states:
- IDLE → MOVING → COLLECTING → SCORING → RETURNING → IDLE
- Change states based on time or conditions
- Print state changes

## 📝 Example Output

Here's what your simulation might look like:

```
=== Robot Simulation Started ===

Time: 0s
Robot State: IDLE
Battery: 100%

Time: 1s
Robot State: MOVING
Battery: 98%
Distance: 3.5 feet

Time: 2s
Robot State: MOVING
Battery: 96%
Distance: 7.0 feet

Time: 5s
Robot State: SCORING
Battery: 90%
Game piece collected! Total: 1

...

=== Simulation Complete ===
Final Battery: 70%
Distance Traveled: 52.5 feet
Game Pieces Scored: 3
```

## 🆘 Need Help?

CONTACT A LEAD

## 🎓 What's Next?
After completing this project, you can:
- Add more complex logic (random events, sensor simulation)
- Create multiple robot "modes"
- Simulate a full 2.5 minute match (not just autonomous)
- Add user input to control the robot
- Create multiple classes (Robot, GamePiece, Field, etc.)