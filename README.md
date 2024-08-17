# Stockbroker Trade Simulation

This project simulates stock trading activities by using a JSON file to manage public companies and their stockbrokers. The simulation ensures that each stockbroker can only handle one trade at a time, and uses synchronization techniques to manage trade completion.

## Overview
- Reads a JSON file containing information about public companies and their stockbrokers.
- Uses synchronization mechanisms (locks and conditions) to manage stockbroker availability.
- Outputs logs indicating when a trade is initiated and completed.

## Features
- JSON Parsing: Reads and parses a JSON file with updated structure.
- Stockbroker Management: Each stockbroker is allocated to a single company and handles trades sequentially.
- Synchronization: Ensures that stockbrokers cannot perform overlapping trades.
- User Interaction: Prompts the user to enter the filename and validates its existence.
