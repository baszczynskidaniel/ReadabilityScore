# 🧠 Readability Score — Text Complexity Analyzer

A Java program that calculates and compares multiple **readability metrics** to estimate the education level or age group required to understand a given text.  
It supports the **Automated Readability Index (ARI)**, **Flesch–Kincaid Grade Level**, **SMOG Index**, and **Coleman–Liau Index**.

---

## 📋 Features

- Reads text from a file provided as a command-line argument  
- Analyzes:
  - Word count  
  - Sentence count  
  - Character count  
  - Syllable count  
  - Polysyllable count  
- Calculates and displays four standard readability metrics:
  - **Automated Readability Index (ARI)**  
  - **Flesch–Kincaid Grade Level (FKGL)**  
  - **Simple Measure of Gobbledygook (SMOG)**  
  - **Coleman–Liau Index (CLI)**  
- Estimates the **approximate reader age** required for comprehension  
- Clean, modular code design:
  - `ReadabilityScore.java` — readability formulas  
  - `TextStatistics.java` — text analysis methods  
  - `Main.java` — entry point and CLI interface  

---

## 🚀 Usage

### 1️⃣ Compile the program
```bash
javac readability/*.java

java readability.Main sample.txt
```
## Sample output

```yaml
Words: 214
Sentences: 12
Characters: 1074
Syllables: 348
Polysyllables: 27

Automated Readability Index: 10.17 (about 15-year-olds).
Flesch–Kincaid readability tests: 9.81 (about 14-year-olds).
Simple Measure of Gobbledygook: 11.05 (about 16-year-olds).
Coleman–Liau index: 10.21 (about 15-year-olds).
```
