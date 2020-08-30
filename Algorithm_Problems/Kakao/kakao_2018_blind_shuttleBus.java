import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class kakao_2018_blind_shuttleBus {
	static class Time implements Comparable<Time> {
		int hour;
		int min;

		Time(int hour, int min) {
			this.hour = hour;
			this.min = min;
		}

		public Time timeAdd(int min) {
			Time tmp = new Time(this.hour, this.min);
			tmp.min = this.min + min;
			if (tmp.min >= 60) {
				tmp.min -= 60;
				tmp.hour = this.hour + 1;
			} else if (tmp.min < 0) {
				tmp.hour = this.hour - 1;
				tmp.min = 60 + tmp.min;
			}
			return tmp;
		}

		@Override
		public int compareTo(Time o) {
			if (this.hour < o.hour) {
				return -1;
			} else if (this.hour > o.hour) {
				return 1;
			} else {
				if (this.min < o.min) {
					return -1;
				} else if (this.min > o.min) {
					return 1;
				} else {
					return 0;
				}
			}
		}
	}

	public static String ret(Time t) {
		String ret = "";
		if (t.hour < 10) {
			ret += "0" + t.hour;
		} else {
			ret += t.hour;
		}
		ret += ":";

		if (t.min < 10) {
			ret += "0" + t.min;
		} else {
			ret += t.min;
		}
		return ret;
	}

	static String answer;

	public static void main(String[] args) {
		int n = 1;
		int t = 1;
		int m = 2;
		String[] timetable = {"08:57","08:58","08:59"};
		List<Time> ttf1 = new ArrayList<>();
		for (String time : timetable) {
			if (Integer.parseInt(time.substring(0, 2)) >= 18 && Integer.parseInt(time.substring(4)) > 0) {
			}else {
				ttf1.add(new Time(Integer.parseInt(time.substring(0, 2)), Integer.parseInt(time.substring(3))));
			}
		}
		
		
		// 도착시간이 빠른 순서대로 정렬
		Collections.sort(ttf1);
	
		Time start = new Time(9, 0);
		
		Time[] bustable = new Time[n];
		bustable[0] = start;
		for (int i = 1; i < n; i++) {
			bustable[i] = bustable[i - 1].timeAdd(t);
		}
		
		List<Time> ttf = new ArrayList<>();
		int lh = bustable[n-1].hour;
		int lm = bustable[n-1].min;
		for(Time person : ttf1) {
			if(person.hour < lh) {
				ttf.add(person);
			}else if(person.hour == lh){
				if(person.min <= lm) {
					ttf.add(person);
				}
			}
		}
		
		
		
		if(ttf.size() == 0)
			answer = ret(bustable[n-1]);
		
		int limit = m;
		int bidx = 0;
		int p_cnt = ttf.size();
		for (int i = 0; i < ttf.size(); i++) {
			Time person = ttf.get(i);
			// 먼저온 순서대로
			// 도착시간이 빠르면 버스에 태운다
			if (bustable[bidx].hour == person.hour) {
				if (bustable[bidx].min >= person.min) {
					// 정원이 남아 있을떄
					if (limit > 0) {
						// 버스 정원 줄이고
						// 기다리는 사람 줄이고
						limit--;
						p_cnt--;
						if (limit == 0) {
							if (bidx != n - 1) {
								bidx++;
								limit = m;
							}else if(bidx == n-1){
								answer = ret(person.timeAdd(-1));
								break;
							}
						}
						if (p_cnt == 0) {
							if (bidx != n - 1) {
								answer = ret(bustable[n - 1]);
							} else { // 마지막 버스이면
								// 정원이 남아있으면
								if (limit > 0) {
									answer = ret(bustable[n - 1]);
									break;
								} else {
									answer = ret(ttf.get(ttf.size() - 1).timeAdd(-1));
									break;
								}
							}
						}
					}else {
						bidx++;
						limit = m;
						i--;
						continue;
					}
				}else {
					bidx++;
					limit = m;
					i--;
					continue;
				}
			}else if(bustable[bidx].hour > person.hour) {
				if (limit > 0) {
					// 버스 정원 줄이고
					// 기다리는 사람 줄이고
					limit--;
					p_cnt--;
					if (limit == 0) {
						if (bidx != n - 1) {
							bidx++;
							limit = m;
						}else if(bidx == n-1){
							answer = ret(person.timeAdd(-1));
							break;
						}
					}
					if (p_cnt == 0) {
						if (bidx != n - 1) {
							answer = ret(bustable[n - 1]);
						} else { // 마지막 버스이면
							// 정원이 남아있으면
							if (limit > 0) {
								answer = ret(bustable[n - 1]);
								break;
							} else {
								answer = ret(ttf.get(ttf.size() - 1).timeAdd(-1));
								break;
							}
						}
					}
				}else {
					bidx++;
					limit = m;
					i--;
					continue;
				}
			}else {
				bidx++;
				limit = m;
				i--;
				continue;
			}
		}
		
		System.out.println(answer);
	}

}
