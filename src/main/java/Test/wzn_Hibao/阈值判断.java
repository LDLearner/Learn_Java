package Test.wzn_Hibao;

public class 阈值判断 {
	/** 判断阈值 */
	public static void fun(String 字母, String 类型, int 类型值, String videoId) {
		// 视频ID尾数135正常值增长、79减速20%、246减速50%、80减速70%
		String lastNumStr = videoId.substring(videoId.length() - 1, videoId.length());
		int lastNum = Integer.parseInt(lastNumStr);
		float 系数 = 0;
		if (lastNum == 1 || lastNum == 3 || lastNum == 5) {
			系数 = (float) 1;
		} else if (lastNum == 7 || lastNum == 9) {
			系数 = (float) (1 - 0.2);
		} else if (lastNum == 2 || lastNum == 4 || lastNum == 6) {
			系数 = (float) (1 - 0.5);
		} else if (lastNum == 8 || lastNum == 0) {
			系数 = (float) (1 - 0.7);
		}

		// 字母：ABCDEFGHIJK
		// 类型：播放0、评论1、收藏2、分享3、粉丝4
		// A
		if (字母.equals("A")) {
			if (类型.equals("播放") && 类型值 >= 0 && 类型值 <= (int) (5 * 系数)) {

			} else if (类型.equals("评论") && 类型值 == 0) {

			} else if (类型.equals("收藏") && 类型值 == 0) {

			} else if (类型.equals("分享") && 类型值 == 0) {

			} else if (类型.equals("粉丝") && 类型值 == 0) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// B
		else if (字母.equals("B")) {
			if (类型.equals("播放") && 类型值 >= (int) (5 * 系数) && 类型值 <= (int) (50 * 系数)) {

			} else if (类型.equals("评论") && 类型值 == 0) {

			} else if (类型.equals("收藏") && 类型值 >= 0 && 类型值 <= (int) (2 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= 0 && 类型值 <= (int) (2 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 == 0) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// C
		else if (字母.equals("C")) {
			if (类型.equals("播放") && 类型值 >= (int) (30 * 系数) && 类型值 <= (int) (80 * 系数)) {

			} else if (类型.equals("评论") && 类型值 == 0) {

			} else if (类型.equals("收藏") && 类型值 >= 0 && 类型值 <= (int) (3 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= 0 && 类型值 <= (int) (3 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 == 0) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// D
		else if (字母.equals("D")) {
			if (类型.equals("播放") && 类型值 >= (int) (50 * 系数) && 类型值 <= (int) (100 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= 0 && 类型值 <= (int) (3 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (5 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (5 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= 0 && 类型值 <= (int) (2 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// E
		else if (字母.equals("E")) {
			if (类型.equals("播放") && 类型值 >= (int) (80 * 系数) && 类型值 <= (int) (160 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= 0 && 类型值 <= (int) (5 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (6 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (6 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= 0 && 类型值 <= (int) (5 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// F
		else if (字母.equals("F")) {
			if (类型.equals("播放") && 类型值 >= (int) (120 * 系数) && 类型值 <= (int) (300 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= 0 && 类型值 <= (int) (5 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (10 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (10 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (5 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// G
		else if (字母.equals("G")) {
			if (类型.equals("播放") && 类型值 >= (int) (300 * 系数) && 类型值 <= (int) (500 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (6 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (15 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (15 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (6 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// H
		else if (字母.equals("H")) {
			if (类型.equals("播放") && 类型值 >= (int) (580 * 系数) && 类型值 <= (int) (650 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= (int) (1 * 系数) && 类型值 <= (int) (10 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (15 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (15 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (6 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// I
		else if (字母.equals("I")) {
			if (类型.equals("播放") && 类型值 >= (int) (500 * 系数) && 类型值 <= (int) (800 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= (int) (3 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (3 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (3 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (7 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// J
		else if (字母.equals("J")) {
			if (类型.equals("播放") && 类型值 >= (int) (700 * 系数) && 类型值 <= (int) (1000 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= (int) (4 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (4 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (4 * 系数) && 类型值 <= (int) (20 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (8 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		// K
		else if (字母.equals("K")) {
			if (类型.equals("播放") && 类型值 >= (int) (900 * 系数) && 类型值 <= (int) (1500 * 系数)) {

			} else if (类型.equals("评论") && 类型值 >= (int) (5 * 系数) && 类型值 <= (int) (25 * 系数)) {

			} else if (类型.equals("收藏") && 类型值 >= (int) (10 * 系数) && 类型值 <= (int) (25 * 系数)) {

			} else if (类型.equals("分享") && 类型值 >= (int) (10 * 系数) && 类型值 <= (int) (25 * 系数)) {

			} else if (类型.equals("粉丝") && 类型值 >= (int) (2 * 系数) && 类型值 <= (int) (10 * 系数)) {

			} else {
				System.out.println("错误---" + "视频:" + videoId + "\t\t字母类型:" + 字母 + "\t\t类型:" + 类型 + "\t\t类型值:" + 类型值);
			}
		}
		//
		else {
			System.out.println(videoId + "\t字母错误");
		}
	}

	public static void main(String[] args) throws Exception {
		fun("A", "评论", 21, "999");
	}
}