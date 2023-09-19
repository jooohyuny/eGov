package com.kwon.gbraucp2.member;

import java.util.List;

public interface MemberMapper {
	public abstract int bye(Member m);
	public abstract Member getMemberByID(Member m);
	public abstract List<Member> getMemberIDByID(Member m);
	public abstract int join(Member m);
	public abstract int update(Member m);
}
