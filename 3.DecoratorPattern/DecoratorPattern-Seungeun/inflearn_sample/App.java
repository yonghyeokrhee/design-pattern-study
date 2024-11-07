package inflearn_sample;

public class App {
    private static boolean enabledSpamFilter = true;

    private static boolean enabledTrimming = true;
    public static void main(String[] args) {
        CommentService commentService = new DefaultCommentService();

        if(enabledTrimming) commentService = new TrimCommentService(commentService);
        if(enabledSpamFilter) commentService = new SpamFilteringCommentDecorator(commentService); // trim을 넣은 것을 한번 더 감싸서 두 개 모두 수행 가능

        Client client = new Client(commentService);
        client.writeComment("오징어게임");
        client.writeComment("보는게 하는거 보다 재밌을 수가 없지...");
        client.writeComment("http://whiteship.me");
    }
}
