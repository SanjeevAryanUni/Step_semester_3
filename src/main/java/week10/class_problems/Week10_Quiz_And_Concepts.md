# Week 10: OOP, Inheritance, Interfaces, and Data Structures — Quiz & Concept Answers

## Part B — Quiz Answers

1. **Q1**: Consider the given UML class diagram. If Student is a derived type of Person, which members are directly accessible within the Student class?
   - **Answer**: **B. # age and + getName()** (Private `- name` is inaccessible directly in derived classes).
2. **Q2**: Which diagram illustrates an invalid class inheritance structure (assuming single inheritance)?
   - **Answer**: **C. Diagram 3, where a class attempts to extend two different classes.**
3. **Q3**: Order of constructor execution for derived type Manager extending Employee extending Person?
   - **Answer**: **B. Person -> Employee -> Manager** (Base class constructors execute first before child constructors).
4. **Q4**: Accessing Base members or overriding operations from within Derived:
   - **Answer**: **C. Derived can directly access protectedField.**
5. **Q5**: Bus extends Vehicle, both define `fare()`. A Vehicle reference points to Bus, `fare()` called:
   - **Answer**: **B. The fare() method defined in Bus.** (Dynamic method dispatch).
6. **Q6**: Distinction between overloading and overriding in Printer and SpecialPrinter:
   - **Answer**: **B. print(text: String) and print(data: int) in Printer are examples of overloading, and SpecialPrinter's print(text: String) is an example of overriding.**
7. **Q7**: Upcasting Circle to Shape reference `s`, which members can be accessed directly?
   - **Answer**: **A. Only members defined in the Shape class.**
8. **Q8**: Shape[] holds Circle and Square, area() called on each in loop:
   - **Answer**: **C. The area() method specific to Circle will be called for shapes[0], and the area() method specific to Square will be called for shapes[1].**
9. **Q9**: Account `a` refers to Current object. Casting:
   - **Answer**: **B. s = (Savings) a; will fail, c = (Current) a; will succeed.**
10. **Q10**: Benefit of processing Plan[] subtypes polymorphically calling bill():
    - **Answer**: **B. It allows uniform processing of different derived objects through a base-type reference, without needing type-specific conditional logic.**
11. **Q11**: Printer operations: essential vs hidden:
    - **Answer**: **A. printDocument() is essential behavior; internalBuffer, loadBuffer(), and sendToPrintHead() are hidden details.**
12. **Q12**: Abstract class Vehicle, concrete Car:
    - **Answer**: **B. A Vehicle reference can refer to a Car object.**
13. **Q13**: Abstract Account with calculateFee(). Concrete SavingsAccount doesn't implement it:
    - **Answer**: **B. SavingsAccount must also be declared as an abstract class.**
14. **Q14**: Compilation error scenario in abstract class Report and MonthlyReport:
    - **Answer**: **B. MonthlyReport attempting to be a concrete class without implementing the abstract method generateBody().**
15. **Q15**: Payable interface specification:
    - **Answer**: **A. It specifies operations a type promises to provide, but not per-object state or direct implementation.**
16. **Q16**: Implicit modifiers of Loggable interface:
    - **Answer**: **B. logMessage() and getLogLevel() are implicitly public abstract.**
17. **Q17**: DataProcessor realizes Serializable and Resettable:
    - **Answer**: **C. Both serialize() from Serializable and reset() from Resettable.**
18. **Q18**: Common protocol for unrelated classes without default implementation or per-object state:
    - **Answer**: **C. Box C (Interface)**
19. **Q19**: Classify Dog-Animal and Eagle-Flyable:
    - **Answer**: **B. Dog IS-A Animal (generalization); Eagle CAN-DO Flyable (realization).**
20. **Q20**: Methods commonly inherited from Object root type:
    - **Answer**: **A. equals(), hashCode(), toString()**

---

## Part C — Concept Questions

1. **Overloading vs. Overriding**:
   - Overloading occurs in the same class (or across subclasses) with the same method name but different parameter signatures; resolved at **compile-time** (static binding).
   - Overriding occurs when a subclass redefines an inherited method with identical name and parameter signature; resolved at **runtime** (dynamic binding).
2. **Constructor Invocation Sequence**:
   - Subclass constructors invoke `super(...)` as the very first statement, cascading up to `Object`. Base class state initializes before subclass state.
3. **Concrete Class vs. Abstract Class vs. Interface**:
   - *Concrete Class:* Can be instantiated, holds full instance state and complete implementation.
   - *Abstract Class:* Cannot be instantiated; shares state and partial/default logic across closely related `IS-A` subclasses.
   - *Interface:* Pure contract specifying `CAN-DO` capabilities for unrelated classes without holding per-object instance state.
4. **Identical Signatures in Two Interfaces**:
   - A single method implementation in the concrete class satisfies both interfaces simultaneously because an interface represents a contract of capability.
5. **equals() and hashCode() Contract**:
   - If two objects are equal according to `equals()`, they must produce the same `hashCode()`. Failing to override `hashCode()` when overriding `equals()` breaks hash-based structures (`HashSet`, `HashMap`), resulting in duplicate entries or failed lookups.
6. **Shallow vs. Deep Copying**:
   - *Shallow Copy:* Copies primitive values and object references (shared references). Mutating a nested object affects both original and clone.
   - *Deep Copy:* Duplicates nested objects recursively so both copies are fully independent.
7. **Inner vs. Static Nested Class**:
   - *Inner (non-static) Class:* Tied to an instance of the outer class and can access its instance members directly.
   - *Static Nested Class:* Independent of outer instances, can only access static members directly.
8. **Array Time Complexities**:
   - *Access by Index:* $O(1)$ due to contiguous memory calculation `base + index * size`.
   - *Insert/Delete in Middle:* $O(n)$ because subsequent elements must shift left or right to maintain contiguous order.
9. **Polymorphism via Base Reference**:
   - The runtime virtual method table (vtable) invokes the actual object's overridden method rather than the reference type's definition, eliminating the need for `instanceof` cascades.
10. **IS-A vs CAN-DO**:
    - Use `IS-A` (inheritance) for shared identity and internal representation between closely related classes (e.g., `SavingsAccount IS-A Account`).
    - Use `CAN-DO` (interfaces) for shared capabilities across unrelated classes (e.g., `Car` and `Phone` both implementing `Chargeable`).
