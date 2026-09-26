# Week 8: Object-Oriented Design & UML — Quiz & Concept Answers

## Part 1: Quiz Answers

1. **Question 1**: Which OOP concept allows the TicketProcessor to interact with different event types uniformly?
   - **Answer**: **C) Polymorphism**
2. **Question 2**: Which OOP principle is primarily enforced by restricting direct modification of `dateOfBirth`?
   - **Answer**: **C) Encapsulation**
3. **Question 3**: UML multiplicity from Author to Book (1 author writes 1..* books)?
   - **Answer**: **C) Author 1 --- 1..* Book**
4. **Question 4**: UML relationship modeling strong ownership where Cart Items are destroyed when Shopping Cart is deleted?
   - **Answer**: **D) Composition**
5. **Question 5**: UML relationship between general Course and specialized ProgrammingCourse ('is-a')?
   - **Answer**: **D) Generalization**
6. **Question 6**: UML relationship between PdfDocument and the Printable interface contract?
   - **Answer**: **C) Realization**
7. **Question 7**: UML relationship between Customer and Order (transactional link without lifecycle dependency)?
   - **Answer**: **B) Association**
8. **Question 8**: UML diagram type best suited to model lifecycle and valid transitions of a Task?
   - **Answer**: **C) State diagram**
9. **Question 9**: Design concept demonstrated by using a generic `ReportGenerator` interface?
   - **Answer**: **B) Abstraction**
10. **Question 10**: UML behavioral model visualizing message flow between objects over time during login?
    - **Answer**: **C) Sequence diagram**

---

## Part 2: Concept Questions Summary

1. **Encapsulation (User Email)**: Restricts direct field access; enforces validation rules (email format, uniqueness) before mutating state to ensure invariant consistency.
2. **Inheritance vs. Composition (Reporting Service)**: Favor composition over inheritance for optional features (`DataExport`, `DataVisualization`) to avoid exponential class explosion and tight coupling.
3. **Polymorphism & Abstraction (Notification Service)**: Using `NotificationChannel` interface allows adding new channels (e.g., `InAppNotification`) without changing `NotificationService` (Open/Closed Principle).
4. **Composition vs. Aggregation**:
   - `Organization` ---◆ `Department` (Composition: Departments cease to exist when Organization dissolves).
   - `Department` ---◇ `Employee` (Aggregation: Employees survive department dissolution).
5. **UML Multiplicity vs. Business Rules (Student & Course)**: Multiplicity is Many-to-Many (`*` to `*`); business rules preventing duplicate active enrollments are domain constraints enforced in application logic.
