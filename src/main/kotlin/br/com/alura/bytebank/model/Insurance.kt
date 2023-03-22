package br.com.alura.bytebank.model

// Primary constructor
class Insurance(type: InsuranceType) {
    var type: InsuranceType = type
        get() = field
        private set
}