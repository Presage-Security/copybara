import com.google.copybara.Destination.DestinationStatus;
import com.google.copybara.TransformResult;
import com.google.copybara.authoring.Author;
    skylark = new SkylarkTestExecutor(options);
        "parameter 'url' has no default value");
  }

  @Test
  public void testHttpUrl() throws Exception {
    GitDestination d = skylark.eval("r", "r = git.destination("
        + "    url = 'http://github.com/foo', \n"
        + ")");
    assertThat(d.describe(Glob.ALL_FILES).get("url")).contains("https://github.com/foo");
  /**
   * regression to ensure we don't do:
   *
   *     git log -- some_path
   *
   *  This doesn't work for fake merges as the merge is not shown when a path is passed even
   *  with -m.
   */
  @Test
  public void getDestinationStatusForFakeMergeAndNonEmptyRoots() throws Exception {
    fetch = "master";
    push = "master";

    Files.createDirectories(workdir.resolve("dir"));
    Files.write(workdir.resolve("dir/file"), "".getBytes());
    GitRepository repo = repo().withWorkTree(workdir);
    repo.add().files("dir/file").run();
    repo.simpleCommand("commit", "-m", "first commit");

    repo.simpleCommand("branch", "foo");

    Files.write(workdir.resolve("dir/file"), "other".getBytes());
    repo.add().files("dir/file").run();
    repo.simpleCommand("commit", "-m", "first commit");

    repo.forceCheckout("foo");

    Files.write(workdir.resolve("dir/file"), "feature".getBytes());
    repo.add().files("dir/file").run();
    repo.simpleCommand("commit", "-m", "first commit");

    repo.forceCheckout("master");

    // Fake merge
    repo.simpleCommand("merge", "-Xours", "foo", "-m",
        "A fake merge\n\n" + DummyOrigin.LABEL_NAME + ": foo");

    destinationFiles = Glob.createGlob(ImmutableList.of("dir/**"));

    DestinationStatus status = destination().newWriter(destinationFiles,
        /*dryRun=*/false, /*groupId=*/null, /*oldWriter=*/null)
        .getDestinationStatus(DummyOrigin.LABEL_NAME);

    assertThat(status).isNotNull();
    assertThat(status.getBaseline()).isEqualTo("foo");
  }

        Glob.createGlob(ImmutableList.of("baz/**")), /*dryRun=*/false, /*groupId=*/null, writer1);
  private void branchChange(Path scratchTree, GitRepository scratchRepo, String branch,
    options.gitDestination.noRebase = true;
                            TransformWorks.EMPTY_CHANGES, "first_commit", /*setRevId=*/ true,
                            ImmutableList::of),
    List<Change<?>> visited = new ArrayList<>();
    GitRepository repository = destinationFirstCommit().getLocalRepo().load(console);