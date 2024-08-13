Drones Application

Introduction
A major new technology is destined to be a disruptive force in the field of transportation: drones. Just as mobile phones allowed developing countries to leapfrog older technologies for personal communication, drones have the potential to leapfrog traditional transportation infrastructure. Useful drone functions include the delivery of small items that are urgently needed in locations with difficult access. For our use case, the load is medications.
Task Description
We have a fleet of 10 drones capable of carrying devices other than cameras and delivering small loads. The specifications for our drones and medications are as follows:

Drone Specifications:
Serial Number: Maximum 100 characters.
Model: Lightweight, Middleweight, Cruiserweight, Heavyweight. Weight Limit: Maximum 500g.
Battery Capacity: Percentage.
State:
IDLE: When created.
LOADED: When loaded with medications.
DELIVERING: When delivering medications.
DELIVERED: After delivering all medications.
RETURNING: Returning to base (if battery is low).

Medication Specifications:
Name: Only letters, numbers, '-', '_'.
Weight: In grams.
Code: Only uppercase letters, underscore, and numbers.

Application Commands
Develop a console application to allow clients to communicate with the drones. The specific communication with the drone is outside the scope of this task. The application should allow the following commands:
- register <serial_number> <model> <weight_limit>: Registers a drone with the given serial number, model, and weight limit.
- load <drone_serial_number> <medication_name> <medication_weight> <medication_code>: Loads a medication onto a drone with the given serial number. The medication should have a name, weight, and code. The drone should be in IDLE or DELIVERING state and have enough battery capacity (above 25%) to load the medication.
- check_status <drone_serial_number>: Displays the current state, battery level, and loaded medications of a drone with the given serial number.
- list_drones: Displays a list of all registered drones along with their current states and battery levels.
- help: Displays a list of available commands and their descriptions.
- deliver <drone_serial_number>: Delivers medications one by one for a drone with the given serial number in a first-in-first-out (FIFO) order. The drone should be in LOADED state and have enough battery capacity (battery level will decrease by 20% for each medication delivered). If all medications are delivered, the state changes to DELIVERED.
- recharge <drone_serial_number>: Recharges the battery of a drone with the given serial number. The drone should be in RETURNING state and have a battery level below 25%. After recharging, the battery level should be 100% and the state should be updated to LOADED or DELIVERING depending on the medications.
  
Requirements
Prevent the drone from being loaded with more weight than it can carry.
Prevent the drone from being in LOADING state if the battery level is below 25%.
Modify the state transitions:
IDLE when created.
LOADED when loaded with medications.
DELIVERING when delivering medications; if there are remaining items to deliver, continue in DELIVERING state.
DELIVERED when all medications are delivered.
Allow loading medications in DELIVERING state.
Remove unload and update_state commands.
Change recharge command to make the drone's battery 100% and update the state to LOADED or DELIVERING as needed after recharging.
Ensure the deliver command updates the state appropriately: LOADED or DELIVERING while delivering, and DELIVERED when all medications are delivered.
