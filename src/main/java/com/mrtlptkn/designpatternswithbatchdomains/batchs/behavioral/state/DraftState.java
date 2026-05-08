package com.mrtlptkn.designpatternswithbatchdomains.batchs.behavioral.state;

public class DraftState implements OpportunityState {

    @Override
    public void startNegotiation(Opportunity opportunity) {
        System.out.println("Negotiation started.");
        // bu state değişiminde bir logic barsa burada onu uygulayıp sonrasında opputunity nesnesinin state güncelliyoruz.
        opportunity.setState(new NegotiationState());
    }

    @Override
    public void win(Opportunity opportunity) {
        // eğer bu state yaklaşımı olmasaydı bu değeri if ile kontrol edecektik.
        throw new IllegalStateException(
                "Draft state cannot transition directly to WON"
        );
    }

    @Override
    public void lose(Opportunity opportunity) {
        System.out.println("Opportunity lost from draft.");
        opportunity.setState(new LostState());
    }

    @Override
    public String name() {
        return "DRAFT";
    }
}