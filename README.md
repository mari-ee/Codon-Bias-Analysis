<div align="center">

<img src="https://readme-typing-svg.herokuapp.com/?font=Barrio&weight=600&size=28&pause=1000&color=F4A7B9&center=true&vCenter=true&width=600&lines=🧬+COVID-19+Codon+Bias+Analysis"/>

<br/>

![Java](https://img.shields.io/badge/Java-%23FFB3C6?style=flat-square&logoColor=white&logo=openjdk)
![Bioinformatics](https://img.shields.io/badge/Bioinformatics-%23FFDAC1?style=flat-square)
![COVID--19](https://img.shields.io/badge/COVID--19%20Genome-%23B5EAD7?style=flat-square)



꩜ ·˚ ༘ 🌷 ·˚ ꩜ · 🌸 ˚ · ꩜ ·˚ ༘ 🌷 ·˚ ꩜

</div>

---

## 🩰 Overview

Codon bias refers to the phenomenon where certain codons are used more frequently than others to encode the same amino acid. This project analyzes the COVID-19 genome sequence to identify codon usage patterns across all amino acids, producing per-codon frequency percentages and overall genome encoding statistics.

---

## 🗂️ Project Structure

```
CodonBiasAnalysis/
├── AminoAcidArrayList.java     ← Main driver and analysis logic
├── AminoAcid.java              ← Amino acid model class
├── aminoAcidTable.csv          ← Input: amino acid and codon mappings
├── covid19Sequence.csv         ← Input: COVID-19 genome codon sequence
└── Covid19BiasAnalysis.txt     ← Output: generated analysis report
```

---

## 🌿 How It Works

1. **Loads amino acid data** from `aminoAcidTable.csv`, mapping each amino acid to its possible codons
2. **Loads the COVID-19 genome sequence** from `covid19Sequence.csv` as an array of codons
3. **Counts codon occurrences** across the genome using a linear search algorithm
4. **Calculates frequencies** — both per-codon usage within an amino acid and each amino acid's overall share of the genome
5. **Writes results** to `Covid19BiasAnalysis.txt` with formatted percentage breakdowns

---

<div align="center">

꩜ ·˚ ༘ 🌸 ·˚ ꩜ · 🌷 ˚ · ꩜ ·˚ ༘ 🌸 ·˚ ꩜

<br/>


</div>
