# Movie Rental System – Final Project

**Course:** SE 4352.501  
**Date:** May 15, 2025

---

## Overview

This project builds on the original movie rental system by adding support for movie purchases and applying coupons. Customers can now rent or buy movies, earn points, and see their transactions summarized. The goal was to make the system flexible, readable, and easy to expand in the future.

---

## Features

- Rent or purchase movies
- Apply coupons to individual rentals or purchases
- Earn points for both renting and buying
- Get a full transaction summary that includes adjusted totals
- Print XML statements and movie reviews

---

## Design Patterns

### Strategy Pattern  
Used for things like rental pricing and how points are awarded. Each pricing rule or point rule is its own strategy, so it's easy to change or add new ones without touching the rest of the code.

### Decorator Pattern  
Used to apply coupons without changing the core rental or purchase classes. For example, there are decorators for:
- 50% off rentals
- $10 off rentals over $50
- 10% off purchases
- Bonus point coupons

This lets us stack or swap out coupons as needed.

---

## How to Compile and Run

1. Make sure you’re in the folder with all the `.java` files.
2. Then run:

```bash
javac *.java
java Main
