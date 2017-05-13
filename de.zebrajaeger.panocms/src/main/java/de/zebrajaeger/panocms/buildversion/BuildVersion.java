package de.zebrajaeger.panocms.buildversion;

import de.zebrajaeger.panocms.PanocmsRuntimeException;
import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.concurrent.LazyInitializer;
import org.apache.commons.logging.Log;
import org.opencms.main.CmsLog;

import java.io.InputStream;
import java.util.Properties;

/**
 * @author Lars Brandt, brandt@silpion.de
 */
public class BuildVersion {

    private static final Log LOG = CmsLog.getLog(BuildVersion.class);

    private static final LazyInitializer<BuildVersion> INITIALIZER = new LazyInitializer<BuildVersion>() {
        @Override
        protected BuildVersion initialize() throws ConcurrentException {
            return new BuildVersion();
        }
    };

    public static BuildVersion instance() {
        try {
            return INITIALIZER.get();
        } catch (ConcurrentException e) {
            throw new PanocmsRuntimeException(e);
        }
    }

    public enum GitKey {
        TAGS("git.tags"),
        COMMIT_ID_ABBREV("git.commit.id.abbrev"),
        COMMIT_USER_EMAIL("git.commit.user.email"),
        COMMIT_MESSAGE_FULL("git.commit.message.full"),
        COMMIT_ID("git.commit.id"),
        COMMIT_ID_DESCRIBE_SHORT("git.commit.id.describe-short"),
        COMMIT_MESSAGE_SHORT("git.commit.message.short"),
        COMMIT_USER_NAME("git.commit.user.name"),
        BUILD_USER_NAME("git.build.user.name"),
        COMMIT_ID_DESCRIBE("git.commit.id.describe"),
        BUILD_USER_EMAIL("git.build.user.email"),
        BRANCH("git.branch"),
        COMMIT_TIME("git.commit.time"),
        DIRTY("git.dirty"),
        BUILD_TIME("git.build.time"),
        REMOTE_ORIGIN_URL("git.remote.origin.url");

        private String name;

        GitKey(String pName) {
            name = pName;
        }

        public String getName() {
            return name;
        }
    }

    /**
     * Content from git.properties file
     */
    private Properties gitProperties;

    public BuildVersion() {
        gitProperties = new Properties();

        try (InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("git.properties")) {
            gitProperties.load(is);
        } catch (Exception e) {
            LOG.error("Error load git.properties for version info. (File is missing?)", e);
        }
    }

    public String get(GitKey value) {
        return get(value, "");
    }

    public String get(GitKey value, String defaultValue) {
        return gitProperties.getProperty(value.getName(), defaultValue);
    }

    public String info() {
        StringBuilder info = new StringBuilder();
        info.append("Commit: ").append(get(GitKey.COMMIT_ID_ABBREV, "-"));
        info.append(" Tag: ").append(get(GitKey.TAGS, "-"));
        info.append(" Branch: ").append(get(GitKey.BRANCH, "-"));
        info.append(" Commit-Time: ").append(get(GitKey.COMMIT_TIME, "-"));
        info.append(" Build-Time: ").append(get(GitKey.BUILD_TIME, "-"));

        return info.toString();
    }
}

