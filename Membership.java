public class Membership {
    private Customer _Customer;
    private boolean _isMember;
    private int _tier;
    
    public Membership(Customer customer, int tier){
        _Customer = customer;
        _isMember = true;
        _tier = tier;
    }

    public boolean getIsMember(){
        return _isMember;
    }

    public void setIsMember( boolean newMembership){
        _isMember = newMembership;
    }

    public int getTier(){
        return _tier;
    }
    public void setTier( int tier){
        _tier = tier;
    }

    public int costOfMembership(){
        if(_tier == 3){
            return 30;
        } else if (_tier == 2) {
            return 20;
        } else if (_tier == 1){
            return 10;
        } else {
            return 0;
        }
    
    }

}
