from . import CreditCardPayment
from. import PayPalPayment
from . import BankTransferPayment
from . import PaymentContext


if __name__ == "__main__":
    credit_card = CreditCardPayment()
    paypal = PayPalPayment()
    bank_transfer = BankTransferPayment()
    payment_context = PaymentContext(credit_card)

    payment_context.make_payment(100)  # Output: Paid 100 using Credit Card.
    payment_context.set_payment_strategy(paypal)

    payment_context.make_payment(50)  # Output: Paid 50 using PayPal.
    payment_context.set_payment_strategy(bank_transfer)
    payment_context.make_payment(200)  # Output: Paid 200 using Bank Transfer.
