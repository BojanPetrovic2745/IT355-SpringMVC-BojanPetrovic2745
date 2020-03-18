package met.local.service;

import java.util.List;
import met.local.domain.Member;

public interface MemberService {
    
    void add(Member member);
    void remove(String memberName);
    List<Member> list();
    
}
